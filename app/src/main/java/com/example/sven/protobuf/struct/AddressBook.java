package com.example.sven.protobuf.struct;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sven
 * @Date 2019/05/29 00:05:24
 *
 */
public class AddressBook {
    List<Person> persons;

    public AddressBook() {
        this.persons = new ArrayList<>();
    }

    public void addPersons(Person person) {
         persons.add(person);
    }

    public List<Person> getPersons( ) {
        return persons;
    }
}
