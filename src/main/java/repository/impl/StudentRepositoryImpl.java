package repository.impl;

import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.StudentRepository;

import java.util.List;

public class StudentRepositoryImpl extends PersonRepositoryImpl<Student> implements StudentRepository<Student> {

    public StudentRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public List<Student> findAll() {
        return em.createQuery("from Student", Student.class).getResultList();
    }
}
