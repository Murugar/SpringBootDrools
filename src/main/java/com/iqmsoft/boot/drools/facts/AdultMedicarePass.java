package com.iqmsoft.boot.drools.facts;

public class AdultMedicarePass extends MedicarePass {

    public AdultMedicarePass(Person person) {
        super(person);
    }
    
    @Override
    public String toString() {
        return "AdultMedicare: { person=" + getPerson() + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AdultMedicarePass that = (AdultMedicarePass) o;
        return getPerson().equals(that.getPerson());
    }

    @Override
    public int hashCode() {
        return getPerson().hashCode();
    }

}
