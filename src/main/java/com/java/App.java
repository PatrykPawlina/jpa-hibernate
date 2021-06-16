package com.java;

import com.java.domain.Bike;
import com.java.domain.BikeType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory myDatabase = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = myDatabase.createEntityManager();

        Bike madone = new Bike("Trek", "Madone", BikeType.ROAD, 2);
        Bike tarmac = new Bike("Specialized", "Tarmac", BikeType.ROAD, 4);
        Bike checkPoint = new Bike("Trek", "Checkpoint SL 7", BikeType.GRAVEL, 4);
        Bike superCaliber = new Bike("Trek", "Supercaliber 9.7", BikeType.CROSS_COUNTRY, 3);
        Bike marlin = new Bike("Trek", "Marlin 8", BikeType.MOUNTAIN, 4);
        Bike fuel = new Bike("Trek", "Fuel EX X01", BikeType.TRAIL, 1);
        Bike remedy = new Bike("Trek", "Slash 9.9 XTR", BikeType.ENDURO, 3);
        Bike session = new Bike("Trek", "Session 9 X01", BikeType.DOWNHILL, 5);
        Bike fat = new Bike("Trek", "Farley 9.6", BikeType.FAT, 2);
        Bike powerFly = new Bike("Trek", "Powerfly FS 9", BikeType.ELECTRIC, 3);
        Bike boone = new Bike("Trek", "Boone 6", BikeType.CYCLOCROSS, 5);
        Bike district = new Bike("Trek", "District 4", BikeType.CITY, 4);


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
