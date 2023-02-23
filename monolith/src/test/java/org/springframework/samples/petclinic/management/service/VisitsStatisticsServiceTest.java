package org.springframework.samples.petclinic.management.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.management.model.YearlyRevenue;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class VisitsStatisticsServiceTest {
    @Autowired
    VisitsStatisticsService service;

    @Test
    void shouldListYearlyRevenue() {
        List<YearlyRevenue> yearlyRevenues = service.listYearlyRevenue();

        assertThat(yearlyRevenues).hasSize(1);
        assertThat(yearlyRevenues.get(0)
                .getTotal()).isEqualTo(800L);
    }


}