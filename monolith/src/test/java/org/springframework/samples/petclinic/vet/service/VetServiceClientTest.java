package org.springframework.samples.petclinic.vet.service;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.vet.dto.VetDTO;

import com.github.tomakehurst.wiremock.WireMockServer;

@SpringBootTest
class VetServiceClientTest {

    private final WireMockServer wireMock = new WireMockServer(options().port(8081));

    @Autowired
    private VetServiceClient client;

    @BeforeEach
    void startWireMock() {
        wireMock.start();
    }

    @AfterEach
    void stopWireMock() {
        wireMock.stop();
    }

    @Test
    void shouldGetVetsViaRestClient() {
        wireMock.stubFor(get(urlEqualTo("/vets")).willReturn(aResponse().withHeader("Content-Type",
                "application/json")
                .withBody(
                        "[{\"firstName\":\"James\",\"lastName\":\"Carter\",\"specialities\":[]},{\"firstName\":\"Helen\",\"lastName\":\"Leary\",\"specialities\":[\"radiology\"]},{\"firstName\":\"Linda\",\"lastName\":\"Douglas\",\"specialities\":[\"dentistry\",\"surgery\"]},{\"firstName\":\"Rafael\",\"lastName\":\"Ortega\",\"specialities\":[\"surgery\"]},{\"firstName\":\"Henry\",\"lastName\":\"Stevens\",\"specialities\":[\"radiology\"]},{\"firstName\":\"Sharon\",\"lastName\":\"Jenkins\",\"specialities\":[]}]")));

        Collection<VetDTO> result = client.allVetDTOs();

        assertThat(result).hasSize(6);
    }

}
