package com.mfnzt.examplestore.application;

import com.mfnzt.examplestore.application.customer.CreateCustomerRequest;
import com.mfnzt.examplestore.application.customer.GetCustomerResponse;
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

    private String getServerUrl() {
        return new StringBuilder()
                .append("http://localhost:")
                .append(port)
                .append("/")
                .append("customers").toString();
    }

    @Test
    void createCustomerShouldReturnAnId() throws Exception {
        // Given
        Customer customer = new Customer();
        customer.setFirstName("Mika");
        customer.setLastName("Doe");
        // When
        ResponseEntity<Long> response = restTemplate.
                postForEntity(getServerUrl(),
                        new CreateCustomerRequest(customer),
                        Long.class);
        // Then
        Assertions.assertInstanceOf(Long.class, response.getBody());
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    void createAndGetCustomerShouldReturnAResult() throws Exception {
        // Given
        Customer customer = new Customer();
        String firstName = "Jane";
        String lastName = "Doe";
        customer.setFirstName(firstName);
        customer.setLastName(lastName);

        ResponseEntity<Long> responseCreateCustomer = restTemplate.
                postForEntity(getServerUrl(),
                        new CreateCustomerRequest(customer),
                        Long.class);
        customer.setId(responseCreateCustomer.getBody());
        // When
        ResponseEntity<GetCustomerResponse> responseGetCustomer = restTemplate.getForEntity(getServerUrl() + "/" + customer.getId(), GetCustomerResponse.class);
        // Then
        Assertions.assertNotNull(responseGetCustomer.getBody());
        Assertions.assertEquals(customer, responseGetCustomer.getBody().getCustomer());
    }
}
