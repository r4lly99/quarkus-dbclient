package org.acme.resource;

import org.acme.domain.Employee;
import org.acme.service.EmployeeService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/api/")
public class EmployeeResource {

    @Inject
    EmployeeService employeeService;

    @GET
    @Path("employees")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> findAllEmployees() {
        return employeeService.getListOfEmployees().get().stream().collect(Collectors.toList());
    }

    @GET
    @Path("employees/{empno}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee findAllEmployees(@PathParam int empno) {
        return employeeService.findEmployeeByEmpNumber(empno).get();
    }

}
