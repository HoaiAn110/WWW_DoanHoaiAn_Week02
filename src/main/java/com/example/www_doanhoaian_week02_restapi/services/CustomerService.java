package com.example.www_doanhoaian_week02_restapi.services;



import com.example.www_doanhoaian_week02_restapi.models.Customer;
import com.example.www_doanhoaian_week02_restapi.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService() {
        customerRepository = new CustomerRepository();
    }

    public void insertCustomer(Customer customer){
        customerRepository.insertCustomer(customer);
    }
    public boolean deleteCustomer(long id){
        return  customerRepository.deleteCustomer(id);
    }
    public void updateCustomer(Customer customer){
        customerRepository.update(customer);
    }

    public Optional<Customer> getCustomerById(long id){
        return  customerRepository.findById(id);
    }
    public List<Customer> getCustomers(){
        return customerRepository.getCustomers();
    }

}
