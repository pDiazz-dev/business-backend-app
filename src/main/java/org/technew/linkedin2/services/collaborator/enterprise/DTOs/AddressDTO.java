package org.technew.linkedin2.services.collaborator.enterprise.DTOs;

import jakarta.validation.constraints.NotBlank;

public record AddressDTO(
        @NotBlank(message = "Street cannot be blank")
        String street,
        String number,
        @NotBlank(message = "Zip code cannot be blank")
        String zipCode,
        String complement,
        @NotBlank(message = "Neighborhood cannot be blank")
        String neighborhood,
        @NotBlank(message = "City cannot be blank")
        String city,
        @NotBlank(message = "State cannot be blank")
        String state,
        @NotBlank(message = "Country cannot be blank")
        String country,
        @NotBlank
        String countryCode
) {
}
