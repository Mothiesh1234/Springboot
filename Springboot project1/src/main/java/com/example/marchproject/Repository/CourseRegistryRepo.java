package com.example.marchproject.Repository;

import com.example.marchproject.Model.CourseRegistry;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRegistryRepo extends JpaRepository<CourseRegistry,Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM CourseRegistry c WHERE c.name = :name")
    void deleteByName(String name);


    @Transactional
    @Modifying
    @Query("UPDATE CourseRegistry c SET c.CourseName = :courseName WHERE c.name = :name")
    void updateCourseByName(String name, String courseName);

}
