package com.creamsale.repositories;

import com.creamsale.dto.ProductDTO;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductDTO, Integer> {
}
