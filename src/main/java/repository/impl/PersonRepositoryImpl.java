package repository.impl;

import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.PersonRepository;
import util.ApplicationContext;

import java.util.List;

public class PersonRepositoryImpl implements PersonRepository<Person> {
    private EntityManager em;
    private EntityTransaction transaction;

    public PersonRepositoryImpl(EntityManager em, EntityTransaction transaction) {
        this.em = em;
        this.transaction = transaction;
    }

    @Override
    public void save(Person person) {
        try {
            transaction.begin();
            em.persist(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Exception in saving from PersonRepository" + e.getMessage());
        }
    }

    @Override
    public void delete(Person person) {
        try {
            transaction.begin();
            em.remove(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Exception in deleting from PersonRepository" + e.getMessage());
        }
    }

    @Override
    public void update(Person person) {
        try {
            transaction.begin();
            em.merge(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Exception in updating from PersonRepository" + e.getMessage());
        }
    }

    @Override
    public Person findById(Long id) {
        return em.find(Person.class, id);
    }

    @Override
    public List<Person> findAll() {
        return em.createQuery("from Person",Person.class).getResultList();
    }
}
