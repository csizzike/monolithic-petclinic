package org.monolithic.petclinic.management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.monolithic.petclinic.management.db.VisitsStatisticsRepository;
import org.monolithic.petclinic.management.model.YearlyRevenue;
import org.monolithic.petclinic.management.model.YearlyRevenueDTO;
import org.springframework.stereotype.Service;

@Service
public class VisitsStatisticsService implements RevenueServiceProxy {

    private final VisitsStatisticsRepository visitsStatisticsRepository;

    public VisitsStatisticsService(VisitsStatisticsRepository visitsStatisticsRepository) {
        this.visitsStatisticsRepository = visitsStatisticsRepository;
    }

    @Override
    public List<YearlyRevenueDTO> listYearlyRevenue() {
        return convertToDto(visitsStatisticsRepository.listYearlyRevenue());
    }

    private List<YearlyRevenueDTO> convertToDto(final List<YearlyRevenue> entities) {
        return entities.stream()
                .map(v -> new YearlyRevenueDTO(v.getYear(),
                        v.getTotal()))
                .collect(Collectors.toList());
    }
}
