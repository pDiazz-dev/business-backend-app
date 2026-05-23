package org.technew.linkedin2.services.collaborator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.technew.linkedin2.model.entities.collaborator.Collaborator;
import org.technew.linkedin2.model.entities.user.RoleType;
import org.technew.linkedin2.model.repositories.collaborator.CollaboratorRepository;
import org.technew.linkedin2.services.security.RolesService;
import org.technew.linkedin2.services.security.UserLoggedService;


@Service
@RequiredArgsConstructor
public class CollaboratorService {
    private final CollaboratorRepository collaboratorRepository;
    private final UserLoggedService userLoggedService;
    private final RolesService rolesService;

    public Collaborator newCollaborator() {
        var userAuthetication = userLoggedService.getLoggedUser();

        if (collaboratorRepository.existsById(userAuthetication.getId())) {
            throw new RuntimeException("User already has a collaborator profile");
        }

        rolesService.attachRole(userAuthetication, RoleType.ROLE_COLLABORATOR);
        Collaborator collaborator = new Collaborator();
        collaborator.setUsers(userAuthetication);
        return collaboratorRepository.save(collaborator);
    }
}
