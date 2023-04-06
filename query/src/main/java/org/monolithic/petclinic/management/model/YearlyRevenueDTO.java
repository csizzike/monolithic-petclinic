package org.monolithic.petclinic.management.model;

public class YearlyRevenueDTO {

    private Integer year;
    private Long total;

    public YearlyRevenueDTO() {
    }

    public YearlyRevenueDTO(Integer year,
                            Long total) {
        this.year = year;
        this.total = total;
    }

    public Integer getYear() {
        return year;
    }

    public Long getTotal() {
        return total;
    }

    public void setYear(final Integer year) {
        this.year = year;
    }

    public void setTotal(final Long total) {
        this.total = total;
    }
}
