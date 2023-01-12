package org.springframework.samples.petclinic.vet.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.vet.db.VetRepository;
import org.springframework.samples.petclinic.vet.dto.VetDTO;
import org.springframework.samples.petclinic.vet.model.Specialty;
import org.springframework.samples.petclinic.vet.model.Vet;
import org.springframework.stereotype.Service;

@Service
public class VetService implements HasVets {

    private final VetRepository vets;

    @Autowired
    public VetService(VetRepository vets) {
        this.vets = vets;
    }

    public Collection<Vet> allVets() {
        return this.vets.findAll();
    }

    @Override
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
