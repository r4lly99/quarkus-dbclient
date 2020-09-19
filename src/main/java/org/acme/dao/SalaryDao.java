package org.acme.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import org.acme.domain.Salary;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class SalaryDao implements PanacheRepository<Salary> {

    public Salary findSalaryByEmpNo(int empNo) { return find("empNo", empNo).firstResult(); }

    public List<Salary> findSalaryGreaterThanValue(int value) {
        return find("salary > :value", Parameters.with("value", value)).list();
    }

}
