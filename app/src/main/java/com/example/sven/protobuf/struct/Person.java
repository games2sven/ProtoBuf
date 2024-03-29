package com.example.sven.protobuf.struct;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Sven
 * @Date 2019/05/29 00:06:31
 *
 */
public class Person {
    private String name;
    private int id;
    private String email;

    private List<PhoneNumber> phones;

    public Person() {
        phones = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void addPhones(PhoneNumber number) {
        phones.add(number);
    }

    public List<PhoneNumber> getPhones() {
        return phones;
    }
}
