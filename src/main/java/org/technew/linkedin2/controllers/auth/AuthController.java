package org.technew.linkedin2.controllers.auth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.technew.linkedin2.model.entities.user.auth.RefreshToken;
import org.technew.linkedin2.services.security.AuthService;
import org.technew.linkedin2.services.security.DTOs.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody AuthLoginDTO authLoginDTO){
        return ResponseEntity.ok(authService.login(authLoginDTO));
    }
    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody RegisterDTO registerDTO){
        authService.register(registerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping("/refresh")
    public ResponseEntity<RefreshTokenResponseDTO> refresh(@Valid @RequestBody RefreshTokenDTO refreshTokenDTO){
        return ResponseEntity.ok(authService.refresh(refreshTokenDTO));
    }
}
