package com.rookie.rookie.repository;

import com.rookie.rookie.domain.Authorize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizeDAO extends JpaRepository<Authorize,Integer> {
}
