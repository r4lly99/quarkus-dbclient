package org.acme.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import org.acme.domain.Employee;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EmployeeDao implements PanacheRepository<Employee> {

    public List<Employee> findByName(String lastName) {
        return find("last_name", lastName).list();
    }

    public List<Employee> findBornAfter(Date date) {
        return find("birth_date > :date", Parameters.with("date", date)).list();
    }

    public Employee findByEmpNo(int empNo){
        return find("empNo", empNo).firstResult();
    }

}
