package org.monolithic.petclinic.management.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.monolithic.petclinic.management.db.VisitsStatisticsRepository;
import org.monolithic.petclinic.management.model.VisitStatistics;
import org.monolithic.petclinic.management.model.YearlyRevenue;
import org.monolithic.petclinic.management.model.YearlyRevenueDTO;
import org.springframework.jms.annotation.JmsListener;
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

    @JmsListener(destination = "visit_statistics")
    public void receiveMessage(Map<String, Object> value) {
        VisitStatistics entity = new VisitStatistics();
        entity.setCost((Integer) value.get("cost"));
        entity.setDate(LocalDate.parse((String) value.get("date"), DateTimeFormatter.ISO_LOCAL_DATE));
        visitsStatisticsRepository.save(entity);
    }

}
