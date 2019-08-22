package com.intellisense.webproject.studentmanagementsystem.user_mgnt.repository;

import com.intellisense.webproject.studentmanagementsystem.user_mgnt.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
