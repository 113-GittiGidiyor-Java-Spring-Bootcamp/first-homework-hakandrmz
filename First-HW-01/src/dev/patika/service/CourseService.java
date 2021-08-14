package dev.patika.service;

import dev.patika.model.Course;
import dev.patika.repository.CourseRepository;
import dev.patika.repository.CrudRepository;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseService implements CrudRepository<Course>, CourseRepository {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Course> findAll() {
        return em.createQuery("from Course",Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return em.find(Course.class,id);
    }

    @Override
    public void saveToDatabase(Course course) {
        try{
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteFromDatabase(Course course) {
        try {
            em.getTransaction().begin();

            Course foundCourse = em.createQuery("from Course c WHERE c.courseCode =:courseCode", Course.class).setParameter("courseCode", course.getCourseCode()).getSingleResult();
            em.remove(foundCourse);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteFromDatabase(int id) {
        try {
            em.getTransaction().begin();

            Course foundCourse = em.find(Course.class, id);
            em.remove(foundCourse);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void updateOnDatabase(Course course, int id) {
        try {
            em.getTransaction().begin();

            Course foundCourse = em.find(Course.class, id);
            foundCourse.setName(course.getName());
            foundCourse.setCourseCode(course.getCourseCode());
            foundCourse.setCredit(course.getCredit());

            em.merge(foundCourse);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
