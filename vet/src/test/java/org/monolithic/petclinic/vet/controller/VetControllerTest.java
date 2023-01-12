package org.monolithic.petclinic.vet.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.monolithic.petclinic.vet.dto.VetDTO;
import org.monolithic.petclinic.vet.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class VetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VetService service;

    @Test
    public void getVets() throws Exception {
        ArrayList<VetDTO> dtos = new ArrayList<>();
        VetDTO vet = new VetDTO("Zaphod",
                "Beeblebrox",
                Collections.emptyList());
        dtos.add(vet);

        Mockito.when(service.allVetDTOs())
                .thenReturn(dtos);

        mockMvc.perform(MockMvcRequestBuilders.get("/vets"))
                .andExpect(status().isOk());
    }

}
