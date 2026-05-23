package org.technew.linkedin2.controllers.collaborator;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.technew.linkedin2.model.entities.collaborator.Collaborator;
import org.technew.linkedin2.services.collaborator.CollaboratorService;

@RestController
@RequestMapping("/collaborator")
@RequiredArgsConstructor
public class CollaboratorController {

    private final CollaboratorService collaboratorService;

    @PostMapping
    public ResponseEntity<Void> newCollaborator(){
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
