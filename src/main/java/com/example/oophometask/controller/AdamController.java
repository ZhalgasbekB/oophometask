package com.example.oophometask.controller;

import com.example.oophometask.entities.Adam;
import com.example.oophometask.entities.Person;
import com.example.oophometask.services.interfaces.IAdamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("adam")
public class AdamController {

    private final IAdamService adamService;

    public AdamController (IAdamService adamService){
        this.adamService = adamService;
    }
    @GetMapping("/login")
    public ModelAndView redirectToLogin(ModelMap model) {
        model.addAttribute("attribute", "redirectWithRedirectPrefix");    return new ModelAndView("login", model);}

    @PostMapping("login")
    public  ModelAndView LoginConnect(@RequestParam ("email")  String email,
                                      @RequestParam("password") String password  , ModelMap modelMap){
          Adam adam = adamService.getAdamByEmail(email);
          modelMap.addAttribute("attribute" , "redirectWithRedirectPrefix");
          return adam == null ? new ModelAndView("login" , modelMap) :  null;
    }

    @GetMapping("/signup")
    public ModelAndView redirectToSignup(ModelMap model) {
        model.addAttribute("attribute", "redirectWithRedirectPrefix");    return new ModelAndView("reg", model);}
    @PostMapping ("/signup")
    public ModelAndView handleFormSubmit(@RequestParam("name") String name,
                                   @RequestParam("surname") String surname,
                                   @RequestParam("email") String email,
                                   @RequestParam("password") String password , ModelMap model) {
        Adam adam =  new Adam(name , surname  , email ,password);
        adamService.signUpSave(adam);
        return redirectToLogin(model);
    }



    @PostMapping("/createAdam")
    public  ResponseEntity <Adam> createAdam(@RequestBody Adam adam){
        Adam saved = adamService.createAdam(adam);
        return new ResponseEntity<>(saved,HttpStatus.CREATED);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<Adam> getAdamByEmail (@PathVariable String email){
        Adam adam = adamService.getAdamByEmail(email);
        return  adam !=  null ? new ResponseEntity<>(adam, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Person> deleteAdamById(@PathVariable int id){
           adamService.deleteAdamById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
