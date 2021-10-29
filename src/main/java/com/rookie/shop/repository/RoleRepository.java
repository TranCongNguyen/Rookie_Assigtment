package com.rookie.shop.repository;

import com.rookie.shop.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Short> {
}
