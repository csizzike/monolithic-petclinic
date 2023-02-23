package org.springframework.samples.petclinic.management.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.samples.petclinic.management.model.YearlyRevenueDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Primary
public class ManagementServiceClient implements RevenueServiceProxy {

    @Value("${spring.management.microservice.url}")
    private String revenuesUrl;

    @Override
    public List<YearlyRevenueDTO> listYearlyRevenue() {
        RestTemplate restTemplate = new RestTemplate();

        YearlyRevenueDTO[] empArray = restTemplate.getForObject(revenuesUrl,
                YearlyRevenueDTO[].class);
        return Arrays.asList(empArray);
    }

}
