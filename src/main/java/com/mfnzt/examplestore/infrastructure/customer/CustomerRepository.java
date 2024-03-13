package com.mfnzt.examplestore.infrastructure.customer;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends ListCrudRepository<CustomerEntity, Long> {
    public List<CustomerEntity> findByLastNameAndFirstName(String lastName, String firstName);
}
