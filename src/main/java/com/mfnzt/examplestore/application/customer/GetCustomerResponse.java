package com.mfnzt.examplestore.application.customer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfnzt.examplestore.domain.customer.Customer;

public class GetCustomerResponse {
    private final Customer customer;

    @JsonCreator
    public GetCustomerResponse(@JsonProperty("customer") final Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
