package org.monolithic.petclinic.vet.service;

import org.junit.jupiter.api.Test;
import org.monolithic.petclinic.vet.dto.VetDTO;
import org.monolithic.petclinic.vet.model.Vet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class VetServiceTest {

    @Autowired
    VetService service;

    @Test
    void shouldFindVets() {
        Collection<Vet> vets = service.allVets();

        assertThat(vets)
                .filteredOn(vet -> vet.getId() == 3)
                .hasSize(1)
                .first()
                .hasFieldOrPropertyWithValue("lastName", "Douglas")
                .hasFieldOrPropertyWithValue("nrOfSpecialties", 2)
                .extracting(Vet::getSpecialties).asList()
                .extracting("name")
                .containsExactly("dentistry", "surgery");
    }

    @Test
    void shouldFindVetDtos() {
        Collection<VetDTO> vets = service.allVetDTOs();

        assertThat(vets)
                .hasSize(6)
                .first()
                .hasFieldOrPropertyWithValue("lastName", "Carter")
                .hasFieldOrPropertyWithValue("firstName", "James")
                .extracting(VetDTO::getSpecialities).asList()
                .isEmpty();

        assertThat(vets)
                .filteredOn(vet -> vet.getFirstName()
                        .equals("Linda"))
                .hasSize(1)
                .first()
                .hasFieldOrPropertyWithValue("lastName", "Douglas")
                .hasFieldOrPropertyWithValue("firstName", "Linda")
                .extracting(VetDTO::getSpecialities).asList()
                .containsExactly("dentistry", "surgery");
    }


}
