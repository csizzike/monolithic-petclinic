package org.springframework.samples.petclinic.vet.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.samples.petclinic.vet.dto.VetDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VetServiceClient implements HasVets {

    @Value("${spring.vet.microservice.url}")
    private String vetsUrl;

    @Override
    public Collection<VetDTO> allVetDTOs() {
        RestTemplate restTemplate = new RestTemplate();

        VetDTO[] empArray = restTemplate.getForObject(vetsUrl,
                VetDTO[].class);
        return Arrays.asList(empArray);
    }

}
