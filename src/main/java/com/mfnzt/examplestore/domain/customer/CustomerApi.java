package com.mfnzt.examplestore.domain.customer;

import java.util.List;

public interface CustomerApi {
    Long createCustomer(Customer customer);
    Customer getCustomerById(Long id);
    List<Customer> getCustomersByLastNameAndFirstName(String lastName, String firstName);
}
