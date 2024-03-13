package com.mfnzt.examplestore.application;

import com.mfnzt.examplestore.application.customer.CreateCustomerRequest;
import com.mfnzt.examplestore.application.customer.CreateCustomerResponse;
import com.mfnzt.examplestore.domain.customer.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpCustomerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void createCustomerShouldReturnAnId() throws Exception {
        // Given
        Customer customer = new Customer();
        customer.setFirstName("Mika");
        customer.setLastName("Doe");
        // When
        ResponseEntity<CreateCustomerResponse> response = restTemplate.
                postForEntity("http://localhost:" + port + "/customers",
                        new CreateCustomerRequest(customer),
                        CreateCustomerResponse.class);
        // Then
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNotNull(response.getBody().getId());
    }
}
