package com.rookie.rookie.service.impl;

import com.rookie.rookie.repository.RatingDAO;
import com.rookie.rookie.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    RatingDAO dao;
}
