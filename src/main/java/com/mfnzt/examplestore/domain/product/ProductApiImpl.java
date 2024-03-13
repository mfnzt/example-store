package com.mfnzt.examplestore.domain.product;

public class ProductApiImpl implements ProductApi {
    private final ProductSpi productSpi;

    public ProductApiImpl(ProductSpi productSpi) {
        this.productSpi = productSpi;
    }

    @Override
    public Product getProductById(Long id) {
        return productSpi.findById(id);
    }

    @Override
    public Long createProduct(Product product) {
        return productSpi.save(product);
    }
}
