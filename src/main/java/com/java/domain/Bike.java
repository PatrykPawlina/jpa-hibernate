package com.java.domain;

import javax.persistence.*;

@Entity
@Table(name = "Bikes")
@SecondaryTable(name = "Owner")
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Brand")
    private String brand;

    @Column(name = "Model")
    private String model;

    @Column(name = "Type")
    private BikeType type;

    @Column(name = "Is_Bike_New")
    private boolean isNew;

    @Column(name = "Age")
    private int age;

    @Column(name = "Price")
    private double price;

    @Column(table = "Owner", name = "Gender")
    private Gender gender;

    @Column(table = "Owner", name = "First_Name")
    private String firstName;

    @Column(table = "Owner", name = "Last_Name")
    private String lastName;

    public Bike() {
    }

    public Bike(String brand, String model, BikeType type, boolean isNew, int age, double price, Gender gender, String firstName, String lastName) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.isNew = isNew;
        this.age = age;
        this.price = price;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BikeType getType() {
        return type;
    }

    public void setType(BikeType type) {
        this.type = type;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
