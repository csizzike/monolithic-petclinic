package org.springframework.samples.petclinic.management.service;

import java.util.List;

import org.springframework.samples.petclinic.management.model.YearlyRevenueDTO;

public interface RevenueServiceProxy {

    List<YearlyRevenueDTO> listYearlyRevenue();

}
