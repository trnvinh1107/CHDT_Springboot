package com.doanjava.nhom9_chdt.repository;

import com.doanjava.nhom9_chdt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleById(Long id);
}


