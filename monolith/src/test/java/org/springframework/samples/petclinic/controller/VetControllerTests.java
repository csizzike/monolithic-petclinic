/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.vet.dto.VetDTO;
import org.springframework.samples.petclinic.vet.service.HasVets;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class VetControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    HasVets service;

    @BeforeEach
    void setup() {
        PetType cat = new PetType();
        cat.setId(3);
        cat.setName("hamster");
        given(this.service.allVetDTOs()).willReturn(Collections.singletonList(new VetDTO("James",
                "Carter",
                Collections.emptyList())));
    }

    @Test
    void testShowVetListHtml() throws Exception {
        mockMvc.perform(get("/vets"))
                .andExpect(status().isOk())
                .andExpect(xpath("//table[@id='vets']").exists())
                .andExpect(xpath("//table[@id='vets']/tbody/tr").nodeCount(1))
                .andExpect(xpath("//table[@id='vets']/tbody/tr[position()=1]/td[position()=1]").string("James Carter"))
                .andExpect(xpath("//table[@id='vets']/tbody/tr[position()=1]/td[position()=2]/span").string("none"));
    }

}
