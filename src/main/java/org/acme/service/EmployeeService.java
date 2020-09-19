package org.acme.service;

import org.acme.dao.EmployeeDao;
import org.acme.domain.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EmployeeService {

    @Inject
    EmployeeDao employeeDao;

    public Optional<List<Employee>> getListOfEmployees(){
        return Optional.ofNullable(employeeDao.listAll());
    }

    public Optional<Employee> findEmployeeByEmpNumber(int employeeNumber) {
        return Optional.ofNullable(employeeDao.findByEmpNo(employeeNumber));
    }

}
