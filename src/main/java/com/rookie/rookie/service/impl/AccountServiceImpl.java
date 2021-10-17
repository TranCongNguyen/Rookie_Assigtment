package com.rookie.rookie.service.impl;

import com.rookie.rookie.repository.AccountDAO;
import com.rookie.rookie.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDAO dao;
}
