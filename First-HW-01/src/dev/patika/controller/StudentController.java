package dev.patika.controller;


import dev.patika.entities.Student;
import dev.patika.service.StudentService;

import java.util.List;

public class StudentController {

    StudentService studentService = new StudentService();

    public List<Student> findAll(){
        return studentService.findAll();
    }

    public Student findById(int id){
        return studentService.findById(id);
    }

    public void save(Student student){
        studentService.saveToDatabase(student);
    }

    public void delete(int id){
        studentService.deleteFromDatabase(id);
    }

    public void delete(Student student){
        studentService.deleteFromDatabase(student);
    }

    public void update(Student student,int id){
        studentService.updateOnDatabase(student,id);
    }

    public List<Student> getAll(int id){
        return studentService.findAll();
    }
}
