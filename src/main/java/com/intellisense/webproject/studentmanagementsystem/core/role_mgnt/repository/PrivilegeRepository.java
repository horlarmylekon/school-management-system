package com.intellisense.webproject.studentmanagementsystem.core.role_mgnt.repository;

import com.intellisense.webproject.studentmanagementsystem.core.role_mgnt.model.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Permissions, Long> {

    Permissions findByName(String privilege);

    @Override
    void delete(Permissions permissions);
}
