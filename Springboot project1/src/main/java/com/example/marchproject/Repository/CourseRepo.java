package com.example.marchproject.Repository;

import com.example.marchproject.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;


@Repository
public interface CourseRepo extends JpaRepository<Course,String> {

}
