package com.mfnzt.examplestore.application.customer;

import com.mfnzt.examplestore.domain.customer.CustomerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerApi customerApi;

    @Autowired
    public CustomerController(CustomerApi customerApi) {
        this.customerApi = customerApi;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    CreateCustomerResponse createCustomer(@RequestBody final CreateCustomerRequest createCustomerRequest) {
        final Long id = customerApi.createCustomer(createCustomerRequest.getCustomer());
        return new CreateCustomerResponse(id);
    }
}
