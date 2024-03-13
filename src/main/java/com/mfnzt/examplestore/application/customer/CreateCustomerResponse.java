package com.mfnzt.examplestore.application.customer;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CreateCustomerResponse {
    private final Long id;

    @JsonCreator
    public CreateCustomerResponse(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
