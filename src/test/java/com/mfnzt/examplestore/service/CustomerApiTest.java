package com.mfnzt.examplestore.service;

import com.mfnzt.examplestore.domain.customer.Customer;
import com.mfnzt.examplestore.domain.customer.CustomerSpi;
import com.mfnzt.examplestore.domain.customer.CustomerApiImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Objects;

@Testcontainers
@SpringBootTest
public class CustomerApiTest {
    private final CustomerApiImpl testedCustomerServiceImpl;

    @Autowired
    public CustomerApiTest(CustomerSpi customerSpi) {
        this.testedCustomerServiceImpl = new CustomerApiImpl(customerSpi);
    }

    @Test
    public void testCreateAndGetCustomer() {
        // Given
        String lastName = "Doe";
        String firstName = "Mika";
        Customer customer = new Customer();
        customer.setLastName(lastName);
        customer.setFirstName(firstName);

        // When
        Long id = testedCustomerServiceImpl.createCustomer(customer);
        // Then
        List<Customer> customerRetrieved = testedCustomerServiceImpl.getCustomersByLastNameAndFirstName(lastName, firstName);
        Assertions.assertNotNull(customerRetrieved);
        Assertions.assertFalse(customerRetrieved.isEmpty());
        Assertions.assertNotNull(customerRetrieved.
                stream().filter(f -> Objects.equals(f.getId(), id)).toList());
    }
}
