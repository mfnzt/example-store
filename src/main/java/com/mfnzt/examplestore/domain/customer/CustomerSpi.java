package com.mfnzt.examplestore.domain.customer;

import java.util.List;

public interface CustomerSpi {
    List<Customer> findByLastNameAndFirstName(String lastName, String firstName);
    Long save(Customer customer);
}
