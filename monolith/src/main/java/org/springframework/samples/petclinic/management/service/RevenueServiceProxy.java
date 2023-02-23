package org.springframework.samples.petclinic.management.service;

import org.springframework.samples.petclinic.management.model.YearlyRevenue;

import java.util.List;

public interface RevenueServiceProxy {

    List<YearlyRevenue> listYearlyRevenue();

}
