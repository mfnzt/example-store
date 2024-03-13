package com.mfnzt.examplestore.application.customer;

import com.fasterxml.jackson.annotation.JsonCreator;

public class GetCustomerRequest {
    private final Long id;

    @JsonCreator
    public GetCustomerRequest(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
