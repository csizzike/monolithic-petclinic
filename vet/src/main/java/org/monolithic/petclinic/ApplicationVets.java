package org.monolithic.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication(proxyBeanMethods = false)
public class ApplicationVets {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationVets.class, args);
    }

}
