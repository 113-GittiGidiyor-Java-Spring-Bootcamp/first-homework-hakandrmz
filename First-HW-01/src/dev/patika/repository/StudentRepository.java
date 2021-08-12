package dev.patika.repository;

import dev.patika.entities.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAllStudentOfCourse(int id);
}
