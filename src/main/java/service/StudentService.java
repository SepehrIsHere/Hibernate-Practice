package service;

import entity.Student;
import repository.StudentRepository;

public class StudentService extends PersonService<Student>{
    public StudentService(StudentRepository<Student> studentRepository) {
        super(studentRepository);
    }
}
