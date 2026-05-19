package org.technew.linkedin2.model.entities.user.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.technew.linkedin2.model.repositories.User.UsersRepository;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImple  implements UserDetailsService {

    private final UsersRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(AuthorizedUser::new)
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }
}
