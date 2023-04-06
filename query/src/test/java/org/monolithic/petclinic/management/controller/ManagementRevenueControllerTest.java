package org.monolithic.petclinic.management.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.monolithic.petclinic.management.model.YearlyRevenueDTO;
import org.monolithic.petclinic.management.service.VisitsStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class ManagementRevenueControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VisitsStatisticsService service;

    @Test
    public void getVets() throws Exception {
        ArrayList<YearlyRevenueDTO> dtos = new ArrayList<>();
        YearlyRevenueDTO yearlyRevenue = new YearlyRevenueDTO(2023,
                200L);
        dtos.add(yearlyRevenue);

        Mockito.when(service.listYearlyRevenue())
                .thenReturn(dtos);

        mockMvc.perform(MockMvcRequestBuilders.get("/revenues"))
                .andExpect(status().isOk()).andExpect(content().string("[{\"year\":2023,\"total\":200}]"));
    }

}
