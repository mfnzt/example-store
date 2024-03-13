package com.mfnzt.examplestore.service;

import com.mfnzt.examplestore.model.Customer;
import com.mfnzt.examplestore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer createCustomer(String lastName, String firstName) {
        Customer newCustomer = new Customer(lastName, firstName);
        return customerRepo.save(newCustomer);
    }

    public List<Customer> getCustomerByLastNameAndFirstName(String lastName, String firstName) {
        return customerRepo.findByLastNameAndFirstName(lastName, firstName);
    }
}
