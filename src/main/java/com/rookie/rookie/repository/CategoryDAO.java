package com.rookie.rookie.repository;

import com.rookie.rookie.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category, String> {
}
