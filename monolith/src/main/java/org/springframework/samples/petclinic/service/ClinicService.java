package org.springframework.samples.petclinic.service;

import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.samples.petclinic.db.OwnerRepository;
import org.springframework.samples.petclinic.db.PetRepository;
import org.springframework.samples.petclinic.db.VisitRepository;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.stereotype.Service;

@Service
public class ClinicService {

    private final OwnerRepository owners;
    private final PetRepository pets;
    private final VisitRepository visits;
    private final JmsTemplate jmsTemplate;

    public ClinicService(final OwnerRepository owners,
                         final PetRepository pets,
                         final VisitRepository visits,
                         final JmsTemplate jmsTemplate) {
        this.owners = owners;
        this.pets = pets;
        this.visits = visits;
        this.jmsTemplate = jmsTemplate;
    }

    public Collection<Owner> ownerByLastName(String lastName) {
        return owners.findByLastName(lastName);
    }

    public Owner ownerById(int i) {
        return owners.findById(i);
    }

    public Pet petById(int id) {
        return pets.findById(id);
    }

    public List<PetType> petTypes() {
        return pets.findPetTypes();
    }

    public List<Visit> visitsByPetId(int petId) {
        return visits.findByPetId(petId);
    }

    public void save(Owner owner) {
        owners.save(owner);
    }

    public void save(Pet pet) {
        pets.save(pet);
    }

    public void save(Visit visit) {
        Map<String, Object> data = new HashMap<>();
        data.put("cost",
                visit.getCost());
        data.put("date",
                visit.getDate()
                        .format(DateTimeFormatter.ISO_LOCAL_DATE));
        jmsTemplate.convertAndSend("visit_statistics",
                data);

        visits.save(visit);
    }

}
