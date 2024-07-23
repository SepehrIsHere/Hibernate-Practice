package repository.impl;

import entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.TeacherRepository;

import java.util.List;

public class TeacherRepositoryImpl implements TeacherRepository {
    private EntityManager em;
    private EntityTransaction transaction;

    public TeacherRepositoryImpl(EntityManager em, EntityTransaction transaction) {
        this.em = em;
        this.transaction = transaction;
    }

    @Override
    public void save(Teacher teacher) {
        try{
            transaction.begin();
            em.persist(teacher);
            transaction.commit();
        }catch(Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Teacher teacher) {
        try{
            transaction.begin();
            em.remove(teacher);
            transaction.commit();
        }catch(Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Teacher teacher) {
        try{
            transaction.begin();
            em.merge(teacher);
            transaction.commit();
        }catch(Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Teacher findById(Long id) {
        return em.find(Teacher.class, id);
    }

    @Override
    public List findAll() {
        return em.createQuery("from Teacher",Teacher.class).getResultList();
    }
}
