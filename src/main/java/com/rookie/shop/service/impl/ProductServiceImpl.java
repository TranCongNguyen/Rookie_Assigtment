package com.rookie.shop.service.impl;

import com.rookie.shop.domain.Product;
import com.rookie.shop.exception.ProductNotFoundException;
import com.rookie.shop.repository.ProductRepository;
import com.rookie.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepo;


    @Override
    public Optional<Product> findAllByName(String name) {
            Optional<Product> opt = productRepo.findByAndSort(name, Sort.by("name"));
            if(!opt.isPresent()){
                throw new ProductNotFoundException("PRODUCT_NOT_FOUND");
            }
            return productRepo.findByAndSort(name, Sort.by("name"));
    }

    @Override
    public Optional<Product> findById(Long id) {
        Optional<Product> opt = productRepo.findById(id);
        if(!opt.isPresent()){
            throw new ProductNotFoundException("PRODUCT_NOT_FOUND");

        }
        return productRepo.findById(id);
    }


}
