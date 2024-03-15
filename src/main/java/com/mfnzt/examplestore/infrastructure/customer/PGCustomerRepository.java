package com.mfnzt.examplestore.infrastructure.customer;

import com.mfnzt.examplestore.domain.customer.Customer;
import com.mfnzt.examplestore.domain.customer.CustomerSpi;
import com.mfnzt.examplestore.infrastructure.customer.CustomerEntity;
import com.mfnzt.examplestore.infrastructure.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class PGCustomerRepository implements CustomerSpi {
    private final CustomerRepository customerRepository;

    @Autowired
    public PGCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public List<Customer> findByLastNameAndFirstName(String lastName, String firstName) {
        return customerRepository.findByLastNameAndFirstName(lastName, firstName)
                .stream()
                .filter(Objects::nonNull)
                .map(CustomerEntity::toCustomer)
                .toList();
    }

    @Override
    public Customer findById(Long id) {
        CustomerEntity customerEntity = customerRepository.findById(id).orElse(null);
        return customerEntity != null ? customerEntity.toCustomer() : null;
    }

    @Override
    public Long save(Customer customer) {
        return customerRepository.save(new CustomerEntity(customer)).getId();
    }
}
