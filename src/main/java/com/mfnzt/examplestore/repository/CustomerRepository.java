package com.mfnzt.examplestore.repository;

import com.mfnzt.examplestore.model.Customer;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends ListCrudRepository<Customer, Long> {
    public List<Customer> findByLastNameAndFirstName(String lastName, String firstName);
}
