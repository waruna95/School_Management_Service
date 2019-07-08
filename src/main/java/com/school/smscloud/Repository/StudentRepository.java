package com.school.smscloud.Repository;

import com.school.smscloud.Modal.School;
import com.school.smscloud.Modal.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
