package com.mfnzt.examplestore.domain.product;

public interface ProductApi {
    Product getProductById(Long id);
    Long createProduct(Product product);
}
