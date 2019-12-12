package com.creamsale.repositories;

import com.creamsale.domain.ShopEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<ShopEntity, Integer> {
}
