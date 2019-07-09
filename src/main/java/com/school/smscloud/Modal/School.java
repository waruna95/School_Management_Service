package com.school.smscloud.Modal;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class School {

    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
   @GenericGenerator(
           name = "book_seq",
           strategy = "com.school.smscloud.Modal.IdGenerator",
           parameters = {
//                 @org.hibernate.annotations.Parameter(name = IdGenerator.INCREMENT_PARAM, value = "50"),
                   @org.hibernate.annotations.Parameter(name = IdGenerator.prefix, value = "EMP_"),
                   @org.hibernate.annotations.Parameter(name = IdGenerator.numberParam, value = "%03d")
           }
   )
    String id;

    String name;
    String city;


    //for return list of students
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    List<Student> students;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
