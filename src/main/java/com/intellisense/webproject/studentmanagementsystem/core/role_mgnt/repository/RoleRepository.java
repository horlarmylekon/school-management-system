package com.intellisense.webproject.studentmanagementsystem.core.role_mgnt.repository;

import com.intellisense.webproject.studentmanagementsystem.core.role_mgnt.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {

    Roles findByName(String name);

    @Override
    void delete(Roles roles);
}
