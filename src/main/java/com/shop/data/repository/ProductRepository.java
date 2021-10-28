package com.shop.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shop.data.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
