package dev.patika.clients;

import dev.patika.entities.*;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;

public class ClientMain {
    public static void main(String[] args) {

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        if(checkTestData() == 0){
            saveTestData();
        }




    }

    private static int checkTestData() {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        return em.createQuery("from Student ", Student.class).getResultList().size();
    }

    private static void saveTestData() {

        Student stu1 = new Student("Hakan", LocalDate.of(2001, 1, 13),"Bursa","M");
        Student stu2 = new Student("Ali",LocalDate.of(2002, 2, 14),"İstanbul","M");
        Student stu3 = new Student("Ayşe",LocalDate.of(2003, 3, 15),"Ankara","F");
        Student stu4 = new Student("Fatma",LocalDate.of(2004, 4, 16),"Adana","F");
        Student stu5 = new Student("Mehmet",LocalDate.of(2005, 7, 17),"Erzurum","M");

        Course course1 = new Course("Algorithm 101","ALG101",6);
        Course course2 = new Course("Data Structures","DS102",5);

        Instructor pi = new PermanentInstructor("Celal","ITU","918273645",100);
        Instructor vi = new VisitingResearcher("Dilan","Kayseri","918273645",300);

        course1.setInstructor(pi);
        course2.setInstructor(vi);

        course1.getStudents().add(stu1);
        course1.getStudents().add(stu2);
        course1.getStudents().add(stu3);
        course1.getStudents().add(stu4);
        course2.getStudents().add(stu3);
        course2.getStudents().add(stu4);
        course2.getStudents().add(stu5);

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin();

            em.persist(pi);
            em.persist(vi);

            em.persist(course1);
            em.persist(course2);

            em.persist(stu1);
            em.persist(stu2);
            em.persist(stu3);
            em.persist(stu4);
            em.persist(stu5);

            em.getTransaction().commit();

            System.out.println("----------------data persisted....---------");
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }
}
