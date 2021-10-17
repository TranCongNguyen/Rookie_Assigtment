package com.rookie.rookie.service.impl;

import com.rookie.rookie.repository.CategoryDAO;
import com.rookie.rookie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDAO dao;
}
