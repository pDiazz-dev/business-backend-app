package org.technew.linkedin2.services.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.technew.linkedin2.model.entities.user.Users;
import org.technew.linkedin2.model.repositories.User.UsersRepository;

@Service
@RequiredArgsConstructor
public class UserLoggedService {
    private final UsersRepository userRepository;

    public Users getLoggedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new RuntimeException("No authenticated user found");
        }
        String email = auth.getName();
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
