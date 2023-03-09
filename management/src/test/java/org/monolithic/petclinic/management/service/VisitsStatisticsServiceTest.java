package org.monolithic.petclinic.management.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.monolithic.petclinic.management.model.YearlyRevenueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VisitsStatisticsServiceTest {
    @Autowired
    VisitsStatisticsService service;

    @Test
    void shouldListYearlyRevenue() {
        List<YearlyRevenueDTO> yearlyRevenues = service.listYearlyRevenue();

        assertThat(yearlyRevenues).hasSize(1);
        assertThat(yearlyRevenues.get(0)
                .getTotal()).isEqualTo(800L);
    }

}
