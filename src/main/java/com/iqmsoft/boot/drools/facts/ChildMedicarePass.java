package com.iqmsoft.boot.drools.facts;

public class ChildMedicarePass extends MedicarePass {

    public ChildMedicarePass(Person person) {
        super(person);
    }

    @Override
    public String toString() {
        return "ChildMedicare: { person=" + getPerson() + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ChildMedicarePass that = (ChildMedicarePass) o;
        return getPerson().equals(that.getPerson());
    }

    @Override
    public int hashCode() {
        return getPerson().hashCode();
    }
    
}