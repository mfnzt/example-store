package com.mfnzt.examplestore.repository;

import com.mfnzt.examplestore.domain.customer.Customer;
import com.mfnzt.examplestore.domain.customer.CustomerSpi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
public class CustomerSpiTest {
    @Autowired
    private CustomerSpi customerSpi;

    @Test
    void createCustomer() {
        String lastName = "Doe";
        String firstName = "Mika";
        // Given
        Customer cust = new Customer();
        cust.setFirstName(firstName);
        cust.setLastName(lastName);

        // When
        customerSpi.save(cust);

        // Then
        Assertions.assertNotNull(customerSpi.findByLastNameAndFirstName(lastName, firstName).getFirst());
    }
}
