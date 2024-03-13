package com.mfnzt.examplestore.service;

import com.mfnzt.examplestore.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

@Testcontainers
@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    CustomerService cs;

    @Test
    public void testCreateAndGetCustomer() {
        // Given
        String lastName = "Doe";
        String firstName = "Mika";
        // When
        cs.createCustomer(lastName, firstName);
        // Then
        List<Customer> customerRetrieved = cs.getCustomerByLastNameAndFirstName(lastName, firstName);
        Assertions.assertNotNull(customerRetrieved);
        Assertions.assertFalse(customerRetrieved.isEmpty());
    }
}
