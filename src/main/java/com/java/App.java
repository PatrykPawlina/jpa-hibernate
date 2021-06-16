package com.java;

import com.java.domain.Bike;
import com.java.domain.BikeType;
import com.java.domain.Gender;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory myDatabase = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = myDatabase.createEntityManager();

        Bike madone = new Bike("Trek", "Madone SLR 9", BikeType.ROAD, true, 0, 12499.99,
                Gender.MALE, "Patryk", "Janowski");
        Bike tarmac = new Bike("Specialized", "Tarmac", BikeType.ROAD, false, 3, 3249.99,
                Gender.MALE, "Roman", "Białoszewski");
        Bike checkPoint = new Bike("Trek", "Checkpoint SL 7", BikeType.GRAVEL, true, 0, 6299.99,
                Gender.FEMALE, "Karolina", "Kowalska");
        Bike superCaliber = new Bike("Trek", "Supercaliber 9.7", BikeType.CROSS_COUNTRY, true, 0, 4799.99,
                Gender.FEMALE, "Izabela", "Nowak");
        Bike marlin = new Bike("Trek", "Marlin 8", BikeType.MOUNTAIN, false, 2, 2249.99,
                Gender.MALE, "Gary", "Fisher");
        Bike fuel = new Bike("Trek", "Fuel EX X01", BikeType.TRAIL, true, 0, 9499.99,
                Gender.FEMALE, "Paulina", "Leśmian");
        Bike remedy = new Bike("Trek", "Slash 9.9 XTR", BikeType.ENDURO, true, 0, 10499.99,
                Gender.MALE, "Sławomir", "Gruza");
        Bike session = new Bike("Trek", "Session 9 X01", BikeType.DOWNHILL, true, 0, 8499.99,
                Gender.MALE, "Jakub", "Kosecki");
        Bike fat = new Bike("Trek", "Farley 9.6", BikeType.FAT, false, 3, 4499.99,
                Gender.FEMALE, "Aleksandra", "Górska");
        Bike powerFly = new Bike("Trek", "Powerfly FS 9", BikeType.ELECTRIC, true, 0, 11149.99,
                Gender.FEMALE, "Katarzyna", "Gawrońska");
        Bike boone = new Bike("Trek", "Boone 6", BikeType.CYCLOCROSS, false, 4, 1899.99,
                Gender.MALE, "Krzysztof", "Nasiński");
        Bike district = new Bike("Trek", "District 4", BikeType.CITY, true, 0, 2699.99,
                Gender.FEMALE, "Dorota", "Lewandowska");

        entityManager.getTransaction().begin();

        entityManager.persist(madone);
        entityManager.persist(tarmac);
        entityManager.persist(checkPoint);
        entityManager.persist(superCaliber);
        entityManager.persist(marlin);
        entityManager.persist(fuel);
        entityManager.persist(remedy);
        entityManager.persist(session);
        entityManager.persist(fat);
        entityManager.persist(powerFly);
        entityManager.persist(boone);
        entityManager.persist(district);

        entityManager.getTransaction().commit();

        myDatabase.close();
        entityManager.close();
    }
}
