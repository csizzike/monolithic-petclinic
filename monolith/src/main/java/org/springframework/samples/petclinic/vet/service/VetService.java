package org.springframework.samples.petclinic.vet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.vet.db.VetRepository;
import org.springframework.samples.petclinic.vet.model.Vet;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
}
