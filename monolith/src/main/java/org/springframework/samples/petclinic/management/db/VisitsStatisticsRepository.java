package org.springframework.samples.petclinic.management.db;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.management.model.VisitStatistics;
import org.springframework.samples.petclinic.management.model.YearlyRevenue;

import java.util.List;

/**
 * Query reports of revenue.
 */
public interface VisitsStatisticsRepository extends Repository<VisitStatistics, Integer> {

    @Query("Select new org.springframework.samples.petclinic.management.model.YearlyRevenue(YEAR(v.date), sum(v.cost)) " +
        "from VisitStatistics v " +
        "group by YEAR(v.date)")
    List<YearlyRevenue> listYearlyRevenue();

    void save(VisitStatistics visit) throws DataAccessException;

}
