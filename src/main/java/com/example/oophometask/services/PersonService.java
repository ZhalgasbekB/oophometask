package com.example.oophometask.services;

import com.example.oophometask.entities.Person;
import com.example.oophometask.repositories.PersonRepository;
import com.example.oophometask.services.interfaces.IPersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    private  final PersonRepository personRepository;

    public PersonService (PersonRepository  personRepository){
        this.personRepository =  personRepository;
    }
    @Override
    public Person getById(int id) {
       var p = personRepository.findById(id);
       return  p.isPresent() ? p.get() : null;
    }


    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deletePersonById(int id) {
        personRepository.deleteById(id);
     }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }
}
