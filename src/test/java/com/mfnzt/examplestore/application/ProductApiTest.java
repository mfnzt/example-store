package com.mfnzt.examplestore.application;

import com.mfnzt.examplestore.domain.product.Product;
import com.mfnzt.examplestore.domain.product.ProductApiImpl;
import com.mfnzt.examplestore.domain.product.ProductSpi;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
public class ProductApiTest {
    private final ProductApiImpl testedProductApiImpl;

    @Autowired
    public ProductApiTest(ProductSpi productSpi) {
        this.testedProductApiImpl = new ProductApiImpl(productSpi);
    }

    @Test
    public void testCreateAndGetProduct() {
        // Given
        Product createdProduct = new Product();
        createdProduct.setName("VTT");
        createdProduct.setDescription("VTT 27,5 pouces");
        createdProduct.setPrice(500.0D);
        // When
        Long id = testedProductApiImpl.createProduct(createdProduct);
        createdProduct.setId(id);
        Product retrievedProduct = testedProductApiImpl.getProductById(id);
        // Then
        Assertions.assertThat(id).isPositive();
        Assertions.assertThat(retrievedProduct).isEqualTo(createdProduct);
    }
}
