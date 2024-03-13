package com.mfnzt.examplestore.application.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfnzt.examplestore.domain.product.Product;

public class GetProductResponse {
    private final Product product;

    @JsonCreator
    public GetProductResponse(@JsonProperty("product") final Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
