package org.springframework.samples.petclinic.management.service;

import org.springframework.context.annotation.Primary;
import org.springframework.samples.petclinic.management.db.VisitsStatisticsRepository;
import org.springframework.samples.petclinic.management.model.YearlyRevenue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class VisitsStatisticsService implements RevenueServiceProxy {

    private final VisitsStatisticsRepository visitsStatisticsRepository;

    public VisitsStatisticsService(VisitsStatisticsRepository visitsStatisticsRepository) {
        this.visitsStatisticsRepository = visitsStatisticsRepository;
    }

    @Override
    public List<YearlyRevenue> listYearlyRevenue() {
        return visitsStatisticsRepository.listYearlyRevenue();
    }
}
