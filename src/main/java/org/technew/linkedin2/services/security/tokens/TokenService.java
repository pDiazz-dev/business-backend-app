package org.technew.linkedin2.services.security.tokens;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import org.technew.linkedin2.model.entities.user.Users;
import org.technew.linkedin2.model.entities.user.auth.RefreshToken;
import org.technew.linkedin2.model.repositories.User.Auth.RefreshTokenRepository;

import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TokenService {

    private static final Long REFRESH_TOKEN_EXPIRES = 86400L; // 1 dia -> 24h
    private static final Long ACCESS_TOKEN_EXPIRES = 300L; // 5 MIN

    private final JwtEncoder jwtEncoder;
    private final RefreshTokenRepository refreshTokenRepository;

    // Generate tokens default
    private String generateToken(Users user, Map<String, Object> claims, Long expires){

        Instant now = Instant.now();

        JwtClaimsSet.Builder builder = JwtClaimsSet.builder()
                .issuer("technew")
                .subject(user.getEmail())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expires));
        if (claims != null){
            claims.forEach(builder::claim);
        }
        JwtClaimsSet jwtClaimsSet = builder.build();

        return jwtEncoder
                .encode(JwtEncoderParameters.from(jwtClaimsSet))
                .getTokenValue();
    }

    // GENERATE ACESS TOKEN
    public String generateAccessToken(Users users){

        String authorities = users.getRoles().stream()
                .map(role -> role.getRoleType().name())
                .collect(Collectors.joining(" "));

        Map<String, Object> claims;
        claims = Map.of(
                "authorites", authorities
        );
        return generateToken(users, claims, ACCESS_TOKEN_EXPIRES);
    }
    //GENERATE REFRESH TOKEN
    public String generateRefreshToken(Users users){
        Map<String, Object> claims;
        claims =  Map.of(
                "token_type", "refresh"
        );
        Instant expiresAt = Instant.now().plusSeconds(REFRESH_TOKEN_EXPIRES); // save like Instant for the database
        String tokenRefresh = generateToken(users, claims, REFRESH_TOKEN_EXPIRES);

        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setExpiresAt(expiresAt);
        refreshToken.setUsers(users);
        refreshToken.setToken(tokenRefresh);

        refreshTokenRepository.save(refreshToken);
        return tokenRefresh;
    }
}
