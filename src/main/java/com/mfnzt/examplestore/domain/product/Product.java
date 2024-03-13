package com.mfnzt.examplestore.domain.product;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private String description;
    private Double price;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (!(obj instanceof Product other)) { return false; }
        return Objects.equals(id, other.id) &&
                Objects.equals(name, other.name) &&
                Objects.equals(description, other.description) &&
                Objects.equals(price, other.price);
    }

}
