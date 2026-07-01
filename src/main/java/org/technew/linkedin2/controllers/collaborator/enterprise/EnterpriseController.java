package org.technew.linkedin2.controllers.collaborator.enterprise;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.technew.linkedin2.controllers.collaborator.enterprise.requestsBody.RequestEnterprise;
import org.technew.linkedin2.services.collaborator.enterprise.DTOs.AddressDTO;
import org.technew.linkedin2.services.collaborator.enterprise.EnterpriseService;

@RestController
@RequestMapping("/enterprise")
@RequiredArgsConstructor
public class EnterpriseController {

    private final EnterpriseService enterpriseService;

    @PostMapping
    public ResponseEntity<Void> newEnterprise(@Valid @RequestBody RequestEnterprise requestEnterprise){
        enterpriseService.newEnterprise(requestEnterprise.addressDTO(), requestEnterprise.enterpriseDTO());
        return ResponseEntity.ok().build();
    }
}
