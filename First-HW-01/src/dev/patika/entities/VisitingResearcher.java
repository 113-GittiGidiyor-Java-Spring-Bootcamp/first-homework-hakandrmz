package dev.patika.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class VisitingResearcher extends Instructor{

    private int hourlySalary;

    @OneToMany(mappedBy = "visitingInstructor")
    private List<Course> courses = new ArrayList<>();

    public VisitingResearcher() {
    }

    public VisitingResearcher(String name, String address, String phoneNumber, int hourlySalary) {
        super(name, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    public int getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(int hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                "hourlySalary=" + hourlySalary +
                ", courses=" + courses +
                '}';
    }
}
