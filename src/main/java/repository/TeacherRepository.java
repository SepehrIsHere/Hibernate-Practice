package repository;

import entity.Teacher;

import java.util.List;

public interface TeacherRepository<T extends Teacher> {
    void save(T teacher);

    void delete(T teacher);

    void update(T teacher);

    T findById(Long id);

    List<T> findAll();
}
