package com.mfnzt.examplestore.application.product;

import com.mfnzt.examplestore.domain.product.Product;
import com.mfnzt.examplestore.domain.product.ProductApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductApi productApi;

    @Autowired
    public ProductController(ProductApi productApi) {
        this.productApi = productApi;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Long createProduct(@RequestBody Product product) {
        return productApi.createProduct(product);
    }

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetProductResponse getProductById(@PathVariable Long id) {
        return new GetProductResponse(productApi.getProductById(id));
    }
}
