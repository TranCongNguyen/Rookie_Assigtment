package com.rookie.rookie.repository;

import com.rookie.rookie.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product,Integer> {
}
