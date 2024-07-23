package repository.impl;

import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.StudentRepository;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private EntityManager em;
    private EntityTransaction transaction;

    public StudentRepositoryImpl(EntityManager em, EntityTransaction transaction) {
        this.em = em;
        this.transaction = transaction;
    }

    @Override
    public void save(Student student) {
        try {
            transaction.begin();
            em.persist(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Student student) {
        try{
            transaction.begin();
            em.remove(student);
            transaction.commit();
        }catch(Exception e){
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Student student) {
        try{
            transaction.begin();
            em.merge(student);
            transaction.commit();
        }catch(Exception e){
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    @Override
    public List findAll() {
        return em.createQuery("from Student",Student.class).getResultList();
    }
}
