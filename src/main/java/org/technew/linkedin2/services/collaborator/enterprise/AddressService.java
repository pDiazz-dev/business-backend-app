package org.technew.linkedin2.services.collaborator.enterprise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.technew.linkedin2.model.entities.collaborator.address.Address;
import org.technew.linkedin2.model.entities.collaborator.address.Cities;
import org.technew.linkedin2.model.entities.collaborator.address.Countries;
import org.technew.linkedin2.model.entities.collaborator.address.States;
import org.technew.linkedin2.model.repositories.collaborator.address.AddressRepository;
import org.technew.linkedin2.model.repositories.collaborator.address.CitiesRepository;
import org.technew.linkedin2.model.repositories.collaborator.address.CountriesRepository;
import org.technew.linkedin2.model.repositories.collaborator.address.StatesRepository;
import org.technew.linkedin2.services.collaborator.enterprise.DTOs.AddressDTO;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final CountriesRepository countriesRepository;
    private final StatesRepository statesRepository;
    private final CitiesRepository citiesRepository;

    public Countries countries(String name){
        if(!countriesRepository.existsByName(name)){
            Countries countries = new Countries();
            countries.setName(name.trim().toUpperCase());
            return countriesRepository.save(countries);
        }
        return countriesRepository.findByName(name).
                orElseThrow(() -> new RuntimeException("Country not found"));
    }

    public States states(String name, Countries countries){
        if(!statesRepository.existsByName(name)){
            States states = new States();
            states.setName(name.trim().toUpperCase());
            states.setCountries(countries);
            return statesRepository.save(states);
        }
        return statesRepository.findByName(name).
                orElseThrow(() -> new RuntimeException("State not found"));
    }

    public Cities cities(String name, States states){
        if (!citiesRepository.existsByName(name)){
            Cities cities = new Cities();
            cities.setName(name.trim().toUpperCase());
            cities.setStates(states);
            return citiesRepository.save(cities);
        }
        return citiesRepository.findByName(name).
                orElseThrow(() -> new RuntimeException("City not found"));
    }

    public Address newAddress(AddressDTO addressDTO){
        var countries = countries(addressDTO.country());
        var states = states(addressDTO.state(), countries);
        var cities = cities(addressDTO.city(), states);

        Address address = new Address();
        address.setStreet(addressDTO.street().trim().toUpperCase());
        address.setZipCode(addressDTO.zipCode().trim().toUpperCase());
        address.setNeighborhood(addressDTO.neighborhood().trim().toUpperCase());
        address.setCities(cities);

        if (addressDTO.complement() == null || addressDTO.complement().isBlank()){
            address.setComplement("S/N");
        } else {
            address.setComplement(addressDTO.complement().trim().toUpperCase());
        }
        if (addressDTO.number() == null || addressDTO.number().isBlank()){
            address.setNumber("S/N");
        } else {
            address.setNumber(addressDTO.number().trim().toUpperCase());
        }

        return address;
    }
}
