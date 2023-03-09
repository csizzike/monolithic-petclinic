package org.monolithic.petclinic.management.service;

import java.util.List;

import org.monolithic.petclinic.management.model.YearlyRevenueDTO;

public interface RevenueServiceProxy {

    List<YearlyRevenueDTO> listYearlyRevenue();

}
