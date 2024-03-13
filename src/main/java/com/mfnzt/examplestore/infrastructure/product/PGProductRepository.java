package com.mfnzt.examplestore.infrastructure.product;

import com.mfnzt.examplestore.domain.product.Product;
import com.mfnzt.examplestore.domain.product.ProductApi;
import com.mfnzt.examplestore.domain.product.ProductSpi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PGProductRepository implements ProductSpi {
    private final ProductRepository productRepository;

    @Autowired
    public PGProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElse(null);
        return productEntity != null ? productEntity.toProduct() : null;
    }

    @Override
    public Long save(Product product) {
        return productRepository.save(new ProductEntity(product)).getId();
    }
}
