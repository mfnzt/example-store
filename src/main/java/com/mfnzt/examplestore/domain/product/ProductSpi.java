package com.mfnzt.examplestore.domain.product;

public interface ProductSpi {
    Product findById(Long id);
    Long save(Product product);
}
