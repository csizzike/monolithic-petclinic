package org.springframework.samples.petclinic.management.service;

import java.util.List;

import org.springframework.samples.petclinic.management.db.RevenueRepository;
import org.springframework.samples.petclinic.management.model.YearlyRevenueDTO;
import org.springframework.stereotype.Service;

@Service
public class RevenueService implements RevenueServiceProxy {

    private final RevenueRepository revenueRepository;

    public RevenueService(RevenueRepository revenueRepository) {
        this.revenueRepository = revenueRepository;
    }

    @Override
    public List<YearlyRevenueDTO> listYearlyRevenue() {
        return revenueRepository.listYearlyRevenue();
    }
}
