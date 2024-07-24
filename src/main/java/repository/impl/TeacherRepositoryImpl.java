package repository.impl;

import entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.TeacherRepository;

import java.util.List;

public class TeacherRepositoryImpl extends PersonRepositoryImpl<Teacher> implements TeacherRepository<Teacher> {

    public TeacherRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public List<Teacher> findAll() {
        return em.createQuery("from Teacher", Teacher.class).getResultList();
    }
}
