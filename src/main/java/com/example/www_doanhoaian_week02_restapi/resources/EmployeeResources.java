package com.example.www_doanhoaian_week02_restapi.resources;


import com.example.www_doanhoaian_week02_restapi.models.Employee;
import com.example.www_doanhoaian_week02_restapi.services.EmployeeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/employees")
public class EmployeeResources {
    @Inject
    private EmployeeService employeeService;
    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getEmp(@PathParam("id") long eid) {
        Optional<Employee> empOpt = employeeService.getEmployeeById(eid);
        if (empOpt.isPresent()) {
            return Response.ok(empOpt.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        //paging if possible
        List<Employee> lst = employeeService.getAll();
        return Response
                .ok(lst)
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Employee employee) {
        //ResponseEntity
        employeeService.insertEmp(employee);
        return Response.ok(employee).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        if (employeeService.deleteEmp(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
