package com.school.smscloud.Service;

import com.school.smscloud.Modal.School;
import com.school.smscloud.Modal.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    Student save(Student student);
    List<Student> fetchAllStudents();
    Student fetchStudent(Student student);
}
