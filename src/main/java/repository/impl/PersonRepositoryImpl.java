package repository.impl;

import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.PersonRepository;

import java.util.List;

public class PersonRepositoryImpl<T extends Person> implements PersonRepository<T> {
    protected final EntityManager em;
    public PersonRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Person person) {
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Person person) {
        em.getTransaction().begin();
        em.remove(em.contains(person) ? person : em.merge(person));
        em.getTransaction().commit();
    }

    @Override
    public void update(Person person) {
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    @Override
    public T findById(Long id) {
        return em.find((Class <T>)Person.class, id);
    }

    @Override
    public List<T> findAll() {
        return em.createQuery("from Person", (Class<T>) Person.class).getResultList();
    }
}
