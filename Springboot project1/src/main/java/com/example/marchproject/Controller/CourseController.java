package com.example.marchproject.Controller;


import com.example.marchproject.Model.Course;
import com.example.marchproject.Model.CourseRegistry;
import com.example.marchproject.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CourseController {

    @Autowired
    CourseService ss;

    @GetMapping("/courses")
    public List<Course>availablecourses(){
        return ss.available();
    }

    @GetMapping("/courseregistry")
    public List<CourseRegistry>enrolled(){
        return ss.enrolled();
    }


    @PostMapping("/register")
    public String enrolled(@RequestParam("name")String name,
                           @RequestParam("EmailId") String emailid,
                           @RequestParam("CourseName") String courseName){
        ss.enrollcourse(name,emailid,courseName);
        return "Congratulations " + name + "! You have been enrolled successfully for the " + courseName +
                ". A confirmation email has been sent to " + emailid;

    }

    @DeleteMapping("/delete")
    public String deleted(@RequestParam("name") String name){
        ss.deletebyname(name);
        return name+" successfully removed you from enrollement";
    }


    @PutMapping("/updatecourse")
    public String updateCourse(@RequestParam("name") String name,
                               @RequestParam("CourseName") String newCourseName) {
        ss.updateCourseByName(name, newCourseName);
        return name + " successfully updated to the course " + newCourseName;
    }
}
