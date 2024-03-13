package com.mfnzt.examplestore.domain.customer;

import java.util.List;

public interface CustomerSpi {
    List<Customer> findByLastNameAndFirstName(String lastName, String firstName);
    Customer findById(Long Id);
    Long save(Customer customer);
}
