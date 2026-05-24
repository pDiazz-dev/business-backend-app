package org.technew.linkedin2.services.collaborator.enterprise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.technew.linkedin2.model.entities.collaborator.Enterprise;
import org.technew.linkedin2.model.repositories.collaborator.CollaboratorRepository;
import org.technew.linkedin2.model.repositories.collaborator.EnterpriseRepository;
import org.technew.linkedin2.model.repositories.collaborator.address.AddressRepository;
import org.technew.linkedin2.services.collaborator.enterprise.DTOs.AddressDTO;
import org.technew.linkedin2.services.collaborator.enterprise.DTOs.EnterpriseDTO;
import org.technew.linkedin2.services.security.UserLoggedService;

@RequiredArgsConstructor
@Service
public class EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;
    private final AddressService addressService;
    private final UserLoggedService userLoggedService;
    private final AddressRepository addressRepository;
    private final CollaboratorRepository collaboratorRepository;

    public void newEnterprise(AddressDTO addressDTO, EnterpriseDTO enterpriseDTO) {
        var user = userLoggedService.getLoggedUser();
        var collaborator = collaboratorRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User does not have a collaborator profile"));
        var address = addressService.newAddress(addressDTO);

        Enterprise enterprise = new Enterprise();
        enterprise.setCollaborator(collaborator);
        enterprise.setName(enterpriseDTO.name().trim().toUpperCase());
        enterprise.setCnpj(enterpriseDTO.cnpj().trim().toUpperCase());
        enterpriseRepository.save(enterprise);
        address.setEnterprise(enterprise);
        addressRepository.save(address);

    }
}
