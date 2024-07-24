package service;

import entity.Teacher;
import repository.TeacherRepository;

public class TeacherService extends PersonService<Teacher> {
    public TeacherService(TeacherRepository<Teacher> teacherRepository) {
        super(teacherRepository);
    }
}
