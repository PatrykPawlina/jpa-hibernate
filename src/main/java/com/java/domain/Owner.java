package com.java.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Owner {

    @Column(name = "Gender")
    private Gender gender;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    public Owner() {
    }

    public Owner(Gender gender, String firstName, String lastName) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
