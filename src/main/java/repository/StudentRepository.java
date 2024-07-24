package repository;

import entity.Student;

import java.util.List;

public interface StudentRepository <T extends Student> extends PersonRepository<T> {

}
