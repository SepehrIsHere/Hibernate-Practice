package service;

import entity.Person;
import repository.PersonRepository;

import java.util.List;

public abstract class PersonService <T extends Person>{
    protected final PersonRepository<T> personRepository;

    public PersonService(PersonRepository<T> personRepository) {
        this.personRepository = personRepository;
    }

    public void save(T person) {
        personRepository.save(person);
    }

    public void delete(T person) {
        personRepository.delete(person);
    }

    public void update(T person) {
        personRepository.update(person);
    }

    public T findById(Long id) {
        return personRepository.findById(id);
    }

    public List<T> findAll() {
        return personRepository.findAll();
    }
}
