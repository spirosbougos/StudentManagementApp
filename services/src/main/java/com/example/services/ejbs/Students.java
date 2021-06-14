package com.example.services.ejbs;

import com.example.services.entities.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
public class Students {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(Students.class);


    public void add(Student student) {
        if (entityManager.contains(student)) {
            entityManager.merge(student);
        } else {
            entityManager.persist(student);
        }
    }

    public boolean delete(int id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteWithException(int id){
        Student student = entityManager.find(Student.class, id);
        try {
            entityManager.remove(student);
            return true;
        }catch (Exception e){
            LOGGER.error("Unexpected Error.");
            return false;
        }
    }

    public List<Student> getAll() {
        TypedQuery<Student> q = entityManager.createNamedQuery(Student.STUDENTS_FIND_ALL, Student.class);
        return q.getResultList();
    }

    public List<Student> getGrade(double grade) {
        TypedQuery<Student> q = entityManager.createNamedQuery(Student.STUDENT_FIND_BY_GRADE, Student.class)
                .setParameter("p", grade);
        return q.getResultList();
    }
}
