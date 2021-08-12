package dev.patika.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PermanentInstructor extends Instructor{

    private int fixedSalary;

    @OneToMany(mappedBy = "permanentInstructor")
    private List<Course> courses = new ArrayList<>();

    public PermanentInstructor() {
    }

    public PermanentInstructor(String name, String address, String phoneNumber, int fixedSalary) {
        super(name, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public int getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(int fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
