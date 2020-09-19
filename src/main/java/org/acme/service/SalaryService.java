package org.acme.service;

import org.acme.dao.SalaryDao;
import org.acme.domain.Salary;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class SalaryService {

    @Inject
    SalaryDao salaryDao;

    public Optional<Salary> getSalaryByEmpNo(int empNo){
        return Optional.ofNullable(salaryDao.findSalaryByEmpNo(empNo));
    }

    public Optional<List<Salary>> getSalaryGreaterThanValue(int value){
        return Optional.ofNullable(salaryDao.findSalaryGreaterThanValue(value));
    }
}
