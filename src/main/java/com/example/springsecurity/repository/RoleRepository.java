package com.example.springsecurity.repository;

import com.example.springsecurity.model.Role;
import com.example.springsecurity.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByRoleName(RoleName roleName);

}
