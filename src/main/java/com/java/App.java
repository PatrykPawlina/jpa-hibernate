package com.java;

import com.java.domain.Bike;
import com.java.domain.BikeType;
import com.java.domain.Gender;
import com.java.domain.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory myDatabase = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = myDatabase.createEntityManager();

        Owner madoneOwner = new Owner(Gender.MALE, "Patryk", "Janowski");
        Bike madone = new Bike("Trek", "Madone SLR 9", BikeType.ROAD, true, 0, 12499.99, madoneOwner);

        Owner tarmacOwner = new Owner(Gender.MALE, "Roman", "Białoszewski");
        Bike tarmac = new Bike("Specialized", "Tarmac", BikeType.ROAD, false, 3, 3249.99, tarmacOwner);

        Owner checkPointOwner = new Owner(Gender.FEMALE, "Karolina", "Kowalska");
        Bike checkPoint = new Bike("Trek", "Checkpoint SL 7", BikeType.GRAVEL, true, 0, 6299.99, checkPointOwner);

        Owner superCaliberOwner = new Owner(Gender.FEMALE, "Izabela", "Nowak");
        Bike superCaliber = new Bike("Trek", "Supercaliber 9.7", BikeType.CROSS_COUNTRY, true, 0, 4799.99, superCaliberOwner);

        Owner marlinOwner = new Owner(Gender.MALE, "Gary", "Fisher");
        Bike marlin = new Bike("Trek", "Marlin 8", BikeType.MOUNTAIN, false, 2, 2249.99, marlinOwner);

        Owner fuelOwner = new Owner(Gender.FEMALE, "Paulina", "Leśmian");
        Bike fuel = new Bike("Trek", "Fuel EX X01", BikeType.TRAIL, true, 0, 9499.99, fuelOwner);

        Owner remedyOwner = new Owner(Gender.MALE, "Sławomir", "Gruza");
        Bike remedy = new Bike("Trek", "Slash 9.9 XTR", BikeType.ENDURO, true, 0, 10499.99, remedyOwner);

        Owner sessionOwner = new Owner(Gender.MALE, "Jakub", "Kosecki");
        Bike session = new Bike("Trek", "Session 9 X01", BikeType.DOWNHILL, true, 0, 8499.99, sessionOwner);

        Owner fatOwner = new Owner(Gender.FEMALE, "Aleksandra", "Górska");
        Bike fat = new Bike("Trek", "Farley 9.6", BikeType.FAT, false, 3, 4499.99, fatOwner);

        Owner powerFlyOwner = new Owner(Gender.FEMALE, "Katarzyna", "Gawrońska");
        Bike powerFly = new Bike("Trek", "Powerfly FS 9", BikeType.ELECTRIC, true, 0, 11149.99, powerFlyOwner);

        Owner booneOwner = new Owner(Gender.MALE, "Krzysztof", "Nasiński");
        Bike boone = new Bike("Trek", "Boone 6", BikeType.CYCLOCROSS, false, 4, 1899.99, booneOwner);

        Owner districtOwner = new Owner(Gender.FEMALE, "Dorota", "Lewandowska");
        Bike district = new Bike("Trek", "District 4", BikeType.CITY, true, 0, 2699.99, districtOwner);

        entityManager.getTransaction().begin();

        entityManager.persist(madone);
        entityManager.persist(madoneOwner);

        entityManager.persist(tarmac);
        entityManager.persist(tarmacOwner);

        entityManager.persist(checkPoint);
        entityManager.persist(checkPointOwner);

        entityManager.persist(superCaliber);
        entityManager.persist(superCaliberOwner);

        entityManager.persist(marlin);
        entityManager.persist(marlinOwner);

        entityManager.persist(fuel);
        entityManager.persist(fuelOwner);

        entityManager.persist(remedy);
        entityManager.persist(remedyOwner);

        entityManager.persist(session);
        entityManager.persist(sessionOwner);

        entityManager.persist(fat);
        entityManager.persist(fatOwner);

        entityManager.persist(powerFly);
        entityManager.persist(powerFlyOwner);

        entityManager.persist(boone);
        entityManager.persist(booneOwner);

        entityManager.persist(district);
        entityManager.persist(districtOwner);

        entityManager.getTransaction().commit();

        myDatabase.close();
        entityManager.close();
    }
}
