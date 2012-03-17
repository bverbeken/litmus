package models;

import play.data.validation.MinSize;
import play.data.validation.Required;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;


public class Person {

	@Required
	public String firstName;

	@MinSize(4)
	public String lastName;

	public Person(String firstName) {
		this(firstName, null);
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	@Override
	public boolean equals(Object that) {
		return reflectionEquals(this, that);
	}

	@Override
	public int hashCode() {
		return reflectionHashCode(this);
	}
}
