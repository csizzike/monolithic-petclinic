package org.springframework.samples.petclinic.vet.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.samples.petclinic.vet.dto.VetDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VetServiceClient implements HasVets {

    @Override
    public Collection<VetDTO> allVetDTOs() {
        RestTemplate restTemplate = new RestTemplate();

        VetDTO[] empArray = restTemplate.getForObject("http://localhost:8081/vets",
                VetDTO[].class);
        return Arrays.asList(empArray);
    }

}
