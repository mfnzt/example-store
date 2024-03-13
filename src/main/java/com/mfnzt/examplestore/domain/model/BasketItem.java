package com.mfnzt.examplestore.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table (name = BasketItem.TABLE_NAME)
@Getter
@Setter
public class BasketItem implements Serializable {
    protected static final String TABLE_NAME = "basket_item";
    @Id
    @Setter(AccessLevel.PROTECTED)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;
}
