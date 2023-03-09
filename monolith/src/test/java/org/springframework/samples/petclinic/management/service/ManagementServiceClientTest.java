package org.springframework.samples.petclinic.management.service;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.management.model.YearlyRevenueDTO;

import com.github.tomakehurst.wiremock.WireMockServer;

@SpringBootTest
class ManagementServiceClientTest {

    private final WireMockServer wireMock = new WireMockServer(options().port(8082));

    @Autowired
    private ManagementServiceClient client;

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
        wireMock.stubFor(get(urlEqualTo("/revenues")).willReturn(aResponse().withHeader("Content-Type",
                "application/json")
                .withBody("[{\"year\":2023,\"total\":200}]")));

        List<YearlyRevenueDTO> result = client.listYearlyRevenue();

        assertThat(result).hasSize(1);
    }

}
