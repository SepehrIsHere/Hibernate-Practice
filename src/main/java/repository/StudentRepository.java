package repository;

import entity.Student;

import java.util.List;

public interface StudentRepository <T extends Student> {
    void save(T student);

    void delete(T student);

    void update(T student);

    T findById(Long id);

    List<T> findAll();
}
