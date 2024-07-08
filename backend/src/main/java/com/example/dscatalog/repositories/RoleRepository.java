package com.example.dscatalog.repositories;

import com.example.dscatalog.entities.Role;
import com.example.dscatalog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
