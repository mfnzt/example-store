package com.mfnzt.examplestore.infrastructure.customer.configuration;

import com.mfnzt.examplestore.ExampleStoreApplication;
import com.mfnzt.examplestore.domain.customer.CustomerSpi;
import com.mfnzt.examplestore.domain.customer.CustomerApi;
import com.mfnzt.examplestore.domain.customer.CustomerApiImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ExampleStoreApplication.class)
public class PGConfiguration {
    @Bean
    CustomerApi customerService(final CustomerSpi customerSpi) {
        return new CustomerApiImpl(customerSpi);
    }
}
