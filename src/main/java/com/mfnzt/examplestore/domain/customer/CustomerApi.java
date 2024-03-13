package com.mfnzt.examplestore.domain.customer;

import java.util.List;

public interface CustomerApi {
    Long createCustomer(Customer customer);
    List<Customer> getCustomersByLastNameAndFirstName(String lastName, String firstName);
}
