package org.technew.linkedin2.controllers.collaborator.enterprise.requestsBody;

import org.technew.linkedin2.services.collaborator.enterprise.DTOs.AddressDTO;
import org.technew.linkedin2.services.collaborator.enterprise.DTOs.EnterpriseDTO;

public record RequestEnterprise(
        EnterpriseDTO enterpriseDTO,
        AddressDTO addressDTO
) {
}
