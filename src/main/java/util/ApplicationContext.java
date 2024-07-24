package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.PersonRepository;
import repository.StudentRepository;
import repository.TeacherRepository;
import repository.impl.PersonRepositoryImpl;
import repository.impl.StudentRepositoryImpl;
import repository.impl.TeacherRepositoryImpl;

public class ApplicationContext {
    private static ApplicationContext instance;
    private EntityManagerFactory emf;
    private EntityManager em;
    private PersonRepository personRepository;
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    private ApplicationContext() {
        emf = Persistence.createEntityManagerFactory("person");
        em = emf.createEntityManager();
        personRepository = new PersonRepositoryImpl(em, em.getTransaction());
        studentRepository = new StudentRepositoryImpl(em, em.getTransaction());
        teacherRepository = new TeacherRepositoryImpl(em, em.getTransaction());
    }

    public static ApplicationContext getInstance() {
        if (instance == null) {
            instance = new ApplicationContext();
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("default");
        }
        return emf;
    }

    public EntityManager getEntityManager() {
        if (em == null) {
            em = getEntityManagerFactory().createEntityManager();
        }
        return em;
    }
}
