package com.mfnzt.examplestore.domain.customer;

import com.mfnzt.examplestore.domain.customer.Customer;
import com.mfnzt.examplestore.domain.customer.CustomerApi;
import com.mfnzt.examplestore.domain.customer.CustomerSpi;

import java.util.List;

public class CustomerApiImpl implements CustomerApi {
    private final CustomerSpi customerSpi;

    public CustomerApiImpl(CustomerSpi customerSpi) {
        this.customerSpi = customerSpi;
    }

    @Override
    public Long createCustomer(Customer customer) {
        return customerSpi.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerSpi.findById(id);
    }

    @Override
    public List<Customer> getCustomersByLastNameAndFirstName(String lastName, String firstName) {
        return customerSpi.findByLastNameAndFirstName(lastName, firstName);
    }
}
