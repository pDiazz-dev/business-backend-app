package org.technew.linkedin2.services.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.technew.linkedin2.model.entities.user.RoleType;
import org.technew.linkedin2.model.entities.user.Users;
import org.technew.linkedin2.model.repositories.User.Auth.RoleRepository;
import org.technew.linkedin2.model.repositories.User.UsersRepository;


@Service
@RequiredArgsConstructor
public class RolesService {

    private final RoleRepository roleRepository;
    private final UsersRepository usersRepository;

    public void attachRole(Users user, RoleType roleType){
        var role = roleRepository.findByRoleType(roleType)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        if (user.getRoles().contains(role)){
            throw new RuntimeException("User already has this role");
        }
        user.getRoles().add(role);
        usersRepository.save(user);
    }
}
