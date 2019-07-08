package com.school.smscloud.Service;

import com.school.smscloud.Modal.Student;
import com.school.smscloud.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student fetchStudent(Integer Id) {
        Optional<Student> optional = studentRepository.findById(Id);
        Student student1 = optional.get();
        return student1;
    }
}
