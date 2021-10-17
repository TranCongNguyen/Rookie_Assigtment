package com.rookie.rookie.service.impl;

import com.rookie.rookie.repository.ProductDAO;
import com.rookie.rookie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO dao;

}
