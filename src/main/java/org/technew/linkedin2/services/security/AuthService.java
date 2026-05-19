package org.technew.linkedin2.services.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.technew.linkedin2.model.entities.user.RoleType;
import org.technew.linkedin2.model.entities.user.Users;
import org.technew.linkedin2.model.repositories.User.Auth.RefreshTokenRepository;
import org.technew.linkedin2.model.repositories.User.Auth.RoleRepository;
import org.technew.linkedin2.model.repositories.User.UsersRepository;
import org.technew.linkedin2.services.security.DTOs.*;
import org.technew.linkedin2.services.security.tokens.TokenService;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UsersRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final RoleRepository roleRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    public LoginResponseDTO login(AuthLoginDTO authLoginDTO) {

        var user = userRepository.findByEmail(authLoginDTO.email())
                .orElseThrow(() -> new RuntimeException("User or password not found"));
        var usernamePassword = new UsernamePasswordAuthenticationToken(authLoginDTO.email(),authLoginDTO.password());
        authenticationManager.authenticate(usernamePassword);

        String acessToken = tokenService.generateAcessToken(user);
        String refreshToken = tokenService.generateRefreshToken(user);

        return new LoginResponseDTO(acessToken, refreshToken);
    }

    public void register(RegisterDTO registerDTO){
        if(userRepository.existsByEmail(registerDTO.email())){
            throw new RuntimeException("User already exists");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());

        var role = roleRepository.findByRoleType(RoleType.ROLE_USER).orElseThrow(() -> new RuntimeException("Role not found"));

        Users users = new Users();
        users.setEmail(registerDTO.email());
        users.setPassword(encryptedPassword);
        users.setName(registerDTO.name());
        users.getRoles().add(role);

        userRepository.save(users);
    }
    public RefreshTokenResponseDTO refresh(RefreshTokenDTO refreshTokenDTO){
        var refreshToken = refreshTokenRepository.findByToken(refreshTokenDTO.token())
                .orElseThrow(() -> new RuntimeException("Invalid refresh token"));
        if (refreshToken.getExpiresAt().isBefore(Instant.now())){
            throw  new RuntimeException("Refresh token expired");
        }

        Users user = refreshToken.getUsers();
        refreshTokenRepository.delete(refreshToken);
        String newAcessToken = tokenService.generateAcessToken(user);
        String newRefreshToken = tokenService.generateRefreshToken(user);

        return new RefreshTokenResponseDTO(newAcessToken, newRefreshToken);

    }
}
