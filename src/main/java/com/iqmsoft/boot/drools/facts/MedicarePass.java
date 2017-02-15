package com.iqmsoft.boot.drools.facts;

public class MedicarePass {

    private Person person;

    public MedicarePass(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getBusPassType() {
        return this.getClass().getSimpleName();
    }
    
    @Override
    public String toString() {
        return "Medicare: { person=" + person + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MedicarePass that = (MedicarePass) o;
        return this.person.equals(that.person);
    }

    @Override
    public int hashCode() {
        return person.hashCode();
    }
}
