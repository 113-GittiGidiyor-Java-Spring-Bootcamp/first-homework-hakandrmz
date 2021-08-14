package dev.patika.model;

import javax.persistence.Entity;

@Entity
public class VisitingResearcher extends Instructor{

    private int salary;

    public VisitingResearcher() {
    }

    public VisitingResearcher(String name, String address, String phoneNumber, int hourlySalary) {
        super(name, address, phoneNumber);
        this.salary = hourlySalary;
    }

    public int getHourlySalary() {
        return salary;
    }

    public void setHourlySalary(int hourlySalary) {
        this.salary = hourlySalary;
    }

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                "hourlySalary=" + salary +
                '}';
    }
}
