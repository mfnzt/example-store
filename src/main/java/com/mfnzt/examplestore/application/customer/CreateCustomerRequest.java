package com.mfnzt.examplestore.application.customer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfnzt.examplestore.domain.customer.Customer;

public class CreateCustomerRequest {
    private Customer customer;

    @JsonCreator
    public CreateCustomerRequest(@JsonProperty("customer") final Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
