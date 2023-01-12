package org.monolithic.petclinic.vet.service;

import org.monolithic.petclinic.vet.db.VetRepository;
import org.monolithic.petclinic.vet.dto.VetDTO;
import org.monolithic.petclinic.vet.model.Specialty;
import org.monolithic.petclinic.vet.model.Vet;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VetService {

    private final VetRepository vets;

    @Autowired
    public VetService(VetRepository vets) {
        this.vets = vets;
    }

    public Collection<Vet> allVets() {
        return this.vets.findAll();
    }

    public Collection<VetDTO> allVetDTOs() {
        return allVets().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private VetDTO convertToDTO(final Vet vet) {
        return new VetDTO(vet.getFirstName(),
                vet.getLastName(),
                getSpecialities(vet.getSpecialties()));
    }

    private List<String> getSpecialities(final List<Specialty> specialties) {
        return specialties.stream()
                .map(Specialty::getName)
                .collect(Collectors.toList());
    }
}
