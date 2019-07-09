package com.school.smscloud.Controller;

import com.school.smscloud.Modal.School;
import com.school.smscloud.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/smscloud")
public class SchoolController {

    @Autowired
    SchoolService schoolService;


    //save the schools
    @RequestMapping(value = "/school", method = RequestMethod.POST)
    public ResponseEntity<School> save(@RequestBody School school) {
        return ResponseEntity.ok(schoolService.save(school));
    }

    //get all schools
    @RequestMapping(value = "/schools", method = RequestMethod.GET)
    public ResponseEntity<List<School>> fetchAllSchools(){
        return ResponseEntity.ok(schoolService.fetchAllSchools());
    }

    //get one school
    @RequestMapping(value = "school", method = RequestMethod.GET)
    public ResponseEntity<School> fetchSchool(@PathVariable String id){
        School school = schoolService.fetchSchool(id);
        if(school == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(school);
        }


    }


}
