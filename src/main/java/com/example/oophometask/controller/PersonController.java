package com.example.oophometask.controller;


import com.example.oophometask.entities.Person;
import com.example.oophometask.services.interfaces.IPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {
    private  final IPersonService personService;

    public PersonController (IPersonService personService){this.personService= personService;}

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson (@PathVariable int id){
          Person p =  personService.getById(id);
          return  p != null ? new ResponseEntity<>(p, HttpStatus.OK) : null;
    }

    @GetMapping("/login")
    public ModelAndView redirectToLogin(ModelMap model) {
        model.addAttribute("attribute", "redirectWithRedirectPrefix");    return new ModelAndView("login", model);}

    @GetMapping("/signup")
    public ModelAndView redirectToSignup(ModelMap model) {
        model.addAttribute("attribute", "redirectWithRedirectPrefix");    return new ModelAndView("reg", model);}


    @PostMapping("/create")
    public  ResponseEntity <Person> create(@RequestBody Person p){
           Person saved =  personService.create(p);
           return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @DeleteMapping ("/delete/{id}")
    public  ResponseEntity <Person> delete(@PathVariable int  id){
         personService.deletePersonById(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Person>> gerAll (){
        var list  =  personService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
