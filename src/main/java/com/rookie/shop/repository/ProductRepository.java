package com.rookie.shop.repository;

import com.rookie.shop.domain.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("select p from Products p where p.productName like ?1%")
    Optional<Product> findByAndSort (String name, Sort sort);

    List<Product> findAllAndSort(Sort sort);
}
