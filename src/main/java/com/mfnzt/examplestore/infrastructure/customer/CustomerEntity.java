package com.mfnzt.examplestore.infrastructure.customer;

import com.mfnzt.examplestore.domain.customer.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Table(name = CustomerEntity.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
public class CustomerEntity implements Serializable {
    protected static final String TABLE_NAME = "customer";

    @Id
    @Setter(AccessLevel.PROTECTED)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;

    public CustomerEntity(Customer customer) {
        this.lastName = customer.getLastName();
        this.firstName = customer.getFirstName();
    }

    public Customer toCustomer() {
        Customer customer = new Customer();
        customer.setFirstName(getFirstName());
        customer.setLastName(getLastName());
        return customer;
    }
}
