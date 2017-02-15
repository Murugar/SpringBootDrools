package com.iqmsoft.boot.drools.facts;

public class SeniorMedicarePass extends MedicarePass {

	public SeniorMedicarePass(Person person) {
		super(person);
	}

	@Override
	public String toString() {
		return "SeniorMedicare: { person=" + getPerson() + " }";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
	    SeniorMedicarePass that = (SeniorMedicarePass) o;
		return getPerson().equals(that.getPerson());
	}

	@Override
	public int hashCode() {
		return getPerson().hashCode();
	}
}
