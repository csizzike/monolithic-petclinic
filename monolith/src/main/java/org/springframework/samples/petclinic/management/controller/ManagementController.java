package org.springframework.samples.petclinic.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.management.service.RevenueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class ManagementController {

    @Autowired
    private RevenueService revenueService;

    @GetMapping("/management/revenue")
    public String showRevenue(Map<String, Object> model) {
        model.put("revenues", revenueService.listYearlyRevenue());
        return "management/showRevenue";
    }

}
