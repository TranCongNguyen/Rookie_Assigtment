package com.rookie.rookie.service.impl;

import com.rookie.rookie.repository.RoleDAO;
import com.rookie.rookie.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDAO dao;
}
