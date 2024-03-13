package com.mfnzt.examplestore.repository;

import com.mfnzt.examplestore.configuration.PostgresqlContainer;
import com.mfnzt.examplestore.model.Customer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    void createCustomer() {
        String lastName = "Doe";
        String firstName = "Mika";
        // Given
        Customer cust = new Customer(lastName, firstName);

        // When
        customerRepository.save(cust);

        // Then
        Assertions.assertNotNull(customerRepository.findByLastNameAndFirstName(lastName, firstName));
    }
}
