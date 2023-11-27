package com.example.www_doanhoaian_week02_restapi.resources;

import com.example.www_doanhoaian_week02_restapi.models.Customer;
import com.example.www_doanhoaian_week02_restapi.services.CustomerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/customers")
public class CustomerResources {
    @Inject
    private CustomerService customerService;
    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getEmp(@PathParam("id") long eid) {
        Optional<Customer> empOpt = customerService.getCustomerById(eid);
        if (empOpt.isPresent()) {
            return Response.ok(empOpt.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        //paging if possible
        List<Customer> lst = customerService.getCustomers();
        return Response.ok(lst).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Customer customer) {
        //ResponseEntity
        customerService.insertCustomer(customer);
        return Response.ok(customer).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        if (customerService.deleteCustomer(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }



}
