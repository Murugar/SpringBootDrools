package com.iqmsoft.boot.drools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iqmsoft.boot.drools.facts.MedicarePass;
import com.iqmsoft.boot.drools.facts.Person;

@RestController
public class MedicareController {

    private static Logger log = LoggerFactory.getLogger(MedicareController.class);

    private final MedicareService medicareService;

    @Autowired
    public MedicareController(MedicareService medicare) {
        this.medicareService = medicare;
    }

    @RequestMapping(value = "/buspass", 
            method = RequestMethod.GET, produces = "application/json")
    public MedicarePass getQuestions(
            @RequestParam(required = true) String name,
            @RequestParam(required = true) int age) {

        Person person = new Person(name, age);

        log.debug("Medicare Pass request received for: " + person);
        
        MedicarePass busPass = medicareService.getMedicare(person);

        return busPass;
    }

}
