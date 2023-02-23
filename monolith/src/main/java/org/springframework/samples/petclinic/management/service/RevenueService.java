package org.springframework.samples.petclinic.management.service;

import java.util.List;

import org.springframework.samples.petclinic.management.db.RevenueRepository;
import org.springframework.samples.petclinic.management.model.YearlyRevenue;
import org.springframework.stereotype.Service;

@Service
public class RevenueService {

    private final RevenueRepository revenueRepository;

    public RevenueService(RevenueRepository revenueRepository) {
        this.revenueRepository = revenueRepository;
    }

    public List<YearlyRevenue> listYearlyRevenue() {
        return revenueRepository.listYearlyRevenue();
    }
}
