package org.technew.linkedin2.services.security.tokens;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.stereotype.Service;
import org.technew.linkedin2.model.repositories.User.Auth.RefreshTokenRepository;

@Service
@RequiredArgsConstructor
public class TokenService {

    private static final Long REFRESH_TOKEN_EXPIRES = 86400L; // 1 dia -> 24h
    private static final Long ACCESS_TOKEN_EXPIRES = 300L; // 5 MIN

    private final JwtEncoder jwtEncoder;
    private final RefreshTokenRepository refreshTokenRepository;


}
