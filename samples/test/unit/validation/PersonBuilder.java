package unit.validation;

import litmus.Builder;
import models.Person;

public class PersonBuilder extends Builder<Person> {

    private String email;

    @Override
    public Person build() {
        Person person = new Person("Ben", "Verbeken");
        person.email = email;
        return person;
    }


    public PersonBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

}