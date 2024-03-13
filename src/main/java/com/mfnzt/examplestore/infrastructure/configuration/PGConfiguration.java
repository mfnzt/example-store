package com.mfnzt.examplestore.infrastructure.configuration;

import com.mfnzt.examplestore.ExampleStoreApplication;
import com.mfnzt.examplestore.domain.customer.CustomerSpi;
import com.mfnzt.examplestore.domain.customer.CustomerApi;
import com.mfnzt.examplestore.domain.customer.CustomerApiImpl;
import com.mfnzt.examplestore.domain.product.ProductApi;
import com.mfnzt.examplestore.domain.product.ProductApiImpl;
import com.mfnzt.examplestore.domain.product.ProductSpi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ExampleStoreApplication.class)
public class PGConfiguration {
    @Bean
    CustomerApi customerApiImpl(final CustomerSpi customerSpi) {
        return new CustomerApiImpl(customerSpi);
    }

    @Bean
    ProductApi productApiImpl(final ProductSpi productSpi) {
        return new ProductApiImpl(productSpi);
    }
}
