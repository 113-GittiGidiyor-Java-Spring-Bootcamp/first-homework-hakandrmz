package dev.patika.repository;

import dev.patika.entities.Course;
import dev.patika.entities.Student;

import java.util.List;

public interface CourseRepository{
    List<Course> getAllCourses(int id);
}
