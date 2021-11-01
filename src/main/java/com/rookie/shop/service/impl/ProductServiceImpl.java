package com.rookie.shop.service.impl;

import com.rookie.shop.repository.ProductRepository;
import com.rookie.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepo;



}
