package com.java.domain;

import javax.persistence.*;

@Entity
@Table(name = "Bikes")
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

    @OneToOne
    @JoinColumn(name = "Owner_ID")
    private Owner owner;

    public Bike() {
    }

    public Bike(String brand, String model, BikeType type, boolean isNew, int age, double price, Owner owner) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.isNew = isNew;
        this.age = age;
        this.price = price;
        this.owner = owner;
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
