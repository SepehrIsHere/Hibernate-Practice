package util;

import entity.Person;
import entity.Student;
import entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Getter;
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
    @Getter
    private final PersonRepository<Person> personRepository;
    @Getter
    private final StudentRepository<Student> studentRepository;
    @Getter
    private final TeacherRepository<Teacher> teacherRepository;

    private ApplicationContext() {
        emf = Persistence.createEntityManagerFactory("person");
        em = emf.createEntityManager();
        personRepository = new PersonRepositoryImpl<>(em);
        studentRepository = new StudentRepositoryImpl(em);
        teacherRepository = new TeacherRepositoryImpl(em);
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
