package com.iqmsoft.boot.drools;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
import org.kie.api.runtime.rule.FactHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqmsoft.boot.drools.facts.MedicarePass;
import com.iqmsoft.boot.drools.facts.Person;

@Service
public class MedicareService {

    private static Logger log = LoggerFactory.getLogger(MedicareService.class);

    private final KieContainer kieContainer;

    @Autowired
    public MedicareService(KieContainer kieContainer) {
        log.info("Initialising a new medicare session.");
        this.kieContainer = kieContainer;
    }

    
    public MedicarePass getMedicare(Person person) {
        KieSession kieSession = kieContainer.newKieSession("MedicareSession");
        kieSession.insert(person);
        kieSession.fireAllRules();
        MedicarePass medicare = findMedicare(kieSession);
        kieSession.dispose();
        return medicare;
    }
    
    
    private MedicarePass findMedicare(KieSession kieSession) {
        
     
        ObjectFilter busPassFilter = new ObjectFilter() {
            public boolean accept(Object object) {
                if (MedicarePass.class.equals(object.getClass())) return true;
                if (MedicarePass.class.equals(object.getClass().getSuperclass())) return true;
                return false;
            }
        };

        
        List<MedicarePass> facts = new ArrayList<MedicarePass>();
        for (FactHandle handle : kieSession.getFactHandles(busPassFilter)) {
            facts.add((MedicarePass) kieSession.getObject(handle));
        }
        if (facts.size() == 0) {
            return null;
        }
        return facts.get(0);
    }
    
   
    @SuppressWarnings("unused")
    private void printFactsMessage(KieSession kieSession) {
        Collection<FactHandle> allHandles = kieSession.getFactHandles();
        
        String msg = "\nAll facts:\n";
        for (FactHandle handle : allHandles) {
            msg += "    " + kieSession.getObject(handle) + "\n";
        }
        System.out.println(msg);
    }

}
