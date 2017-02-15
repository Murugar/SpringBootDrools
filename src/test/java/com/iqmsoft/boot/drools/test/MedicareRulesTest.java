package com.iqmsoft.boot.drools.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class MedicareRulesTest {

    private KieServices kieServices;
    private KieContainer kieContainer;
    private KieSession kieSession;
    
    @Before
    public void initialize() {
        if (kieSession != null) {
            kieSession.dispose();
        }
        this.kieServices = KieServices.Factory.get();
        this.kieContainer = kieServices.getKieClasspathContainer();
        this.kieSession = kieContainer.newKieSession("MedicareSession");
    }

    
    @Test
    public void shouldConfigureDroolsComponents() {
        assertNotNull(kieSession);
    }

}
