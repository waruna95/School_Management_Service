package com.school.smscloud.Service;

import com.school.smscloud.Modal.School;
import com.school.smscloud.Modal.Student;
import org.springframework.http.HttpHeaders;

import java.util.List;

public interface SchoolService {
    School save(School school);
    List<School> fetchAllSchools();
    School fetchSchool(Integer Id);

}
