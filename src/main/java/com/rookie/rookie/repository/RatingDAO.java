package com.rookie.rookie.repository;

import com.rookie.rookie.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingDAO extends JpaRepository<Rating,Integer> {
}
