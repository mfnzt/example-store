package com.mfnzt.examplestore.model;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    @Test
    void testCreateCustomer() {
        // Given
        String lastName = "Do";
        String firstName = "Mika";

        // When
        Customer cust = new Customer(lastName, firstName);

        // Then
        Assertions.assertEquals(lastName, cust.getLastName());
        Assertions.assertEquals(firstName, cust.getFirstName());
    }
}
