package com.example.springboot_3_07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/")
    public String index(Model model) {
        // first lets create a person
        Person person = new Person();
        person.setName("Tamia White");
        person.setSsn("111-22-2333");

        // Now lets create a passport
        Passport passport = new Passport();
        passport.setName("Tamia White");
        passport.setBirthday("March 27 1998");

        // Add the passport to the person
        person.setPassport(passport);

        // Save the person to the database
        personRepository.save(person);

        //grab all the persons from the database and send them to
        // the template
        model.addAttribute("persons", personRepository.findAll());
        return "index";
    }
}
