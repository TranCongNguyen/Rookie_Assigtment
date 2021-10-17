package com.rookie.rookie.service.impl;

import com.rookie.rookie.repository.AuthorizeDAO;
import com.rookie.rookie.service.AuthorizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeServiceImpl implements AuthorizeService {
    @Autowired
    AuthorizeDAO dao;
}
