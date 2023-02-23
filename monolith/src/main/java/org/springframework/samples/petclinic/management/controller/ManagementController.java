package org.springframework.samples.petclinic.management.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.management.service.RevenueServiceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagementController {

    @Autowired
    private RevenueServiceProxy revenueService;

    @GetMapping("/management/revenue")
    public String showRevenue(Map<String, Object> model) {
        model.put("revenues",
                revenueService.listYearlyRevenue());
        return "management/showRevenue";
    }

}
