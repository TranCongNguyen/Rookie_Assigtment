package com.rookie.rookie.repository;

import com.rookie.rookie.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role,String> {
}
