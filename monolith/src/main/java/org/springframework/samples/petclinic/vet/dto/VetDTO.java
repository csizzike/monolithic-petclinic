package org.springframework.samples.petclinic.vet.dto;

import java.util.List;

public class VetDTO {

    private String firstName;

    private String lastName;

    private List<String> specialities;

    public VetDTO(final String firstName,
                  final String lastName,
                  final List<String> specialities) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialities = specialities;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getSpecialities() {
        return specialities;
    }
}
