package org.acme.resource;

import org.acme.domain.Employee;
import org.acme.domain.Salary;
import org.acme.service.SalaryService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/")
public class SalaryResource {

    @Inject
    SalaryService salaryService;

    @GET
    @Path("salary/{empno}")
    @Produces(MediaType.APPLICATION_JSON)
    public Salary getSalaryByEmpNo(@PathParam int empno) {
        return salaryService.getSalaryByEmpNo(empno).get();
    }
}
