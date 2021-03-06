package org.acme.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import org.acme.domain.Employee;

import javax.inject.Singleton;
import java.util.Date;
import java.util.List;

@Singleton
public class EmployeeDao implements PanacheRepository<Employee> {

    public List<Employee> findByName(String lastName) {
        return find("lastName", lastName).list();
    }

    public List<Employee> findBornAfter(Date date) {
        return find("birthDate > :date", Parameters.with("date", date)).list();
    }

    public Employee findByEmpNo(int empNo){
        return find("empNo", empNo).firstResult();
    }

}
