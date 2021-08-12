package dev.patika.controller;

import dev.patika.entities.Course;
import dev.patika.service.CourseService;

import java.util.List;

public class CourseController {

    CourseService courseService = new CourseService();

    public List<Course> findAll(){
        return courseService.findAll();
    }

    public Course findById(int id){
        return courseService.findById(id);
    }

    public void save(Course course){
        courseService.saveToDatabase(course);
    }

    public void delete(int id){
        courseService.deleteFromDatabase(id);
    }

    public void delete(Course course){
        courseService.deleteFromDatabase(course);
    }

    public void update(Course cource,int id){
        courseService.updateOnDatabase(cource,id);
    }

    public List<Course> getAll(int id){
        return courseService.findAll();
    }
}
