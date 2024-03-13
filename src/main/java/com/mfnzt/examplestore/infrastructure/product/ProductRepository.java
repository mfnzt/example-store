package com.mfnzt.examplestore.infrastructure.product;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ListCrudRepository<ProductEntity, Long> {
}
