package com.example.oophometask.services.interfaces;

import com.example.oophometask.entities.Person;

import java.util.List;

public interface IPersonService {
     Person getById (int id );

     Person create(Person person);

      void deletePersonById(int id );
     List<Person> getAll ();
}
