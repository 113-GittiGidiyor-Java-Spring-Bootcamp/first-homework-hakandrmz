package dev.patika.model;

import javax.persistence.Entity;

@Entity
public class PermanentInstructor extends Instructor{

    private int salary;

    public PermanentInstructor() {
    }

    public PermanentInstructor(String name, String address, String phoneNumber, int fixedSalary) {
        super(name, address, phoneNumber);
        this.salary = fixedSalary;
    }

    public int getFixedSalary() {
        return salary;
    }

    public void setFixedSalary(int fixedSalary) {
        this.salary = fixedSalary;
    }

    @Override
    public String toString() {
        return "PermanentInstructor{" +
                "fixedSalary=" + salary +
                '}';
    }
}
