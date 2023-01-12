package org.springframework.samples.petclinic.vet.service;

import org.springframework.samples.petclinic.vet.dto.VetDTO;

import java.util.Collection;

public interface HasVets {

    Collection<VetDTO> allVetDTOs();

}
