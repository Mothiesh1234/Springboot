package com.example.marchproject.Service;

import com.example.marchproject.Model.Course;
import com.example.marchproject.Model.CourseRegistry;
import com.example.marchproject.Repository.CourseRegistryRepo;
import com.example.marchproject.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepo repo;

    @Autowired
    CourseRegistryRepo rr;

    @Autowired
    private JavaMailSender mailSender;  // Fix: Autowire the mail sender

    public List<Course> available() {
        return repo.findAll();
    }

    public List<CourseRegistry> enrolled() {
        return rr.findAll();
    }

    public void enrollcourse(String name, String emailid, String courseName) {
        CourseRegistry cr = new CourseRegistry(name, emailid, courseName);
        rr.save(cr);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mothiesh370@gmail.com");
        message.setTo(emailid);
        message.setSubject("Course Enrollment Confirmation");
        message.setText("Dear " + name + ",\n\nCongratulations! You have successfully enrolled in the course: " + courseName + ".\n\nBest Regards,\nCourse Management Team");

        mailSender.send(message);
        System.out.println("Enrollment confirmation email sent successfully.");
    }

    public void deletebyname(String name) {
        rr.deleteByName(name);
    }

    public void updateCourseByName(String name, String newCourseName) {
        rr.updateCourseByName(name, newCourseName);
    }
}

