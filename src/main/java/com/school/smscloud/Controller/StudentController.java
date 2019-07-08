package com.school.smscloud.Controller;

import com.school.smscloud.Modal.Student;
import com.school.smscloud.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class StudentController {

    @Autowired
    StudentService studentService;


    //save the schools
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ResponseEntity<Student> save(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.save(student));
    }

    //get all schools
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> fetchAllStudents(){
        return ResponseEntity.ok(studentService.fetchAllStudents());
    }

    //get one school
    @RequestMapping(value = "student", method = RequestMethod.GET)
    public ResponseEntity<Student> fetchStudent(@PathVariable Integer id){
        Student school = studentService.fetchStudent(id);
        if(school == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(school);
        }


    }

    }
}
