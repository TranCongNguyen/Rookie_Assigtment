package com.rookie.shop.service;

import com.rookie.shop.domain.Product;
import org.springframework.data.domain.Sort;


import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findAllByName(String name);

    Optional<Product> findById(Long id);
}
