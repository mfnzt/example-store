package com.mfnzt.examplestore.domain.customer;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Customer {
    private Long id;
    private String lastName;
    private String firstName;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (!(obj instanceof Customer other)) { return false; }
        return Objects.equals(id, other.id) &&
                Objects.equals(lastName, other.lastName) &&
                Objects.equals(firstName, other.firstName);
    }
}
