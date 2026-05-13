package org.technew.linkedin2.model.entities.user.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.technew.linkedin2.model.repositories.User.UserRepository;

@RequiredArgsConstructor
public class UserDetailsServiceImple  implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(AuthorizedUser::new)
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }
}
