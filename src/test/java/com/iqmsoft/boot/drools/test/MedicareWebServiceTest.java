package com.iqmsoft.boot.drools.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.iqmsoft.boot.drools.MedicareApp;
import com.iqmsoft.boot.drools.MedicareService;
import com.iqmsoft.boot.drools.facts.AdultMedicarePass;
import com.iqmsoft.boot.drools.facts.MedicarePass;
import com.iqmsoft.boot.drools.facts.ChildMedicarePass;
import com.iqmsoft.boot.drools.facts.Person;
import com.iqmsoft.boot.drools.facts.SeniorMedicarePass;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MedicareApp.class)
@WebAppConfiguration
public class MedicareWebServiceTest {

    @Autowired
    private MedicareService medicare;

    
    @Test
    public void shouldIssueSeniorMedicarePass() {
        Person person = new Person("Williams", 68);
        MedicarePass medicare1 = medicare.getMedicare(person);
        
        System.out.println("Medicare : " + medicare1);
        
        assertEquals(SeniorMedicarePass.class, medicare1.getClass());
    }
    
    @Test
    public void shouldIssueAdultMedicarePass() {
        Person person = new Person("Steve", 16);
        MedicarePass medicare1 = medicare.getMedicare(person);
        
        System.out.println("Medicare: " + medicare1);
        
        assertEquals(AdultMedicarePass.class, medicare1.getClass());
    }
    
    @Test
    public void shouldIssueChildBusPass() {
        Person person = new Person("Steve", 15);
        MedicarePass medicare1 = medicare.getMedicare(person);
        
        System.out.println("Medicare : " + medicare1);
        
        assertEquals(ChildMedicarePass.class, medicare1.getClass());
    }

}
