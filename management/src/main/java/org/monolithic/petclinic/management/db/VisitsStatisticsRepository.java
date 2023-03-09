package org.monolithic.petclinic.management.db;

import java.util.List;

import org.monolithic.petclinic.management.model.VisitStatistics;
import org.monolithic.petclinic.management.model.YearlyRevenue;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * Query reports of revenue.
 */
public interface VisitsStatisticsRepository extends Repository<VisitStatistics, Integer> {

    @Query("Select new org.monolithic.petclinic.management.model.YearlyRevenue(YEAR(v.date), sum(v.cost)) " + "from VisitStatistics v "
            + "group by YEAR(v.date)")
    List<YearlyRevenue> listYearlyRevenue();

    void save(VisitStatistics visit) throws DataAccessException;

}
