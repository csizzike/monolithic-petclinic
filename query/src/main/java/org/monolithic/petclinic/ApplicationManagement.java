package org.monolithic.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication(proxyBeanMethods = false)
public class ApplicationManagement {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationManagement.class, args);
    }

}
