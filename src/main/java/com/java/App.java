package com.java;

import com.java.domain.Bike;
import com.java.domain.BikeType;
import com.java.domain.Gender;
import com.java.domain.Owner;

import javax.persistence.*;
import java.util.List;

public class App {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {

        entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        entityManager = entityManagerFactory.createEntityManager();

        addBike();

        TypedQuery<Bike> singleQuery = entityManager.createQuery(
                "select b from Bike b where b.model='Tarmac'", Bike.class);
        singleQueryResult(singleQuery);

        TypedQuery<Bike> complexQuery = entityManager.createQuery(
                "select b from Bike b where b.brand='Trek' order by b.price", Bike.class);
        List<Bike> trekBikesList = complexQuery.getResultList();
        for (Bike bike : trekBikesList) {
            System.out.println("---------------------------");
            complexQueryResult(bike);
        }

        Query ownersList = entityManager.createQuery(
                "select concat(o.firstName,' ',o.lastName) from Owner o order by o.firstName");
        List owners = ownersList.getResultList();
        for (Object owner : owners) {
            System.out.println(owner);
        }

        TypedQuery<Bike> minPricequery = entityManager.createQuery(
                "select b from Bike b where b.price > :minPrice order by b.price", Bike.class);
        minPricequery.setParameter("minPrice", 5000.0);
        List<Bike> resultList = minPricequery.getResultList();
        for (Bike bike : resultList) {
            complexQueryResult(bike);
            System.out.println();
        }

        TypedQuery<Bike> priceQuery = entityManager.createQuery(
                "select b from Bike b where b.price > ?1 and b.price< ?2 order by b.price", Bike.class);
        priceQuery.setParameter(1, 4000.0);
        priceQuery.setParameter(2, 9000.0);
        List<Bike> result = priceQuery.getResultList();
        for (Bike bike : result) {
            complexQueryResult(bike);
            System.out.println();
        }

        entityManager.close();
        entityManagerFactory.close();
    }

    private static void complexQueryResult(Bike bike) {
        System.out.println(bike.getBrand());
        System.out.println(bike.getModel());
        System.out.println(bike.getType());
        System.out.println(bike.isNew());
        System.out.println(bike.getAge());
        System.out.println(bike.getPrice());
        System.out.println(bike.getOwner().getGender());
        System.out.println(bike.getOwner().getFirstName());
        System.out.println(bike.getOwner().getLastName());
    }

    private static void singleQueryResult(TypedQuery<Bike> singleQuery) {
        Bike singleResult = singleQuery.getSingleResult();
        complexQueryResult(singleResult);
    }

    private static void addBike(String brand, String model, BikeType type, boolean isNew, int age, double price, Owner owner) {
        Bike bike = new Bike();
        bike.setBrand(brand);
        bike.setModel(model);
        bike.setType(type);
        bike.setNew(isNew);
        bike.setAge(age);
        bike.setPrice(price);
        bike.setOwner(owner);

        entityManager.getTransaction().begin();
        entityManager.persist(owner);
        entityManager.persist(bike);
        entityManager.getTransaction().commit();
    }

    private static void addBike() {
        addBike("Trek", "Madone SLR 9", BikeType.ROAD, true, 0, 12499.99,
                new Owner(Gender.MALE, "Patryk", "Janowski"));
        addBike("Specialized", "Tarmac", BikeType.ROAD, false, 3, 3249.99,
                new Owner(Gender.MALE, "Roman", "Białoszewski"));
        addBike("Trek", "Checkpoint SL 7", BikeType.GRAVEL, true, 0, 6299.99,
                new Owner(Gender.FEMALE, "Karolina", "Kowalska"));
        addBike("Trek", "Supercaliber 9.7", BikeType.CROSS_COUNTRY, true, 0, 4799.99,
                new Owner(Gender.FEMALE, "Izabela", "Nowak"));
        addBike("Trek", "Marlin 8", BikeType.MOUNTAIN, false, 2, 2249.99,
                new Owner(Gender.MALE, "Gary", "Fisher"));
        addBike("Trek", "Fuel EX X01", BikeType.TRAIL, true, 0, 9499.99,
                new Owner(Gender.FEMALE, "Paulina", "Leśmian"));
        addBike("Trek", "Slash 9.9 XTR", BikeType.ENDURO, true, 0, 10499.99,
                new Owner(Gender.MALE, "Sławomir", "Gruza"));
        addBike("Trek", "Session 9 X01", BikeType.DOWNHILL, true, 0, 8499.99,
                new Owner(Gender.MALE, "Jakub", "Kosecki"));
        addBike("Trek", "Farley 9.6", BikeType.FAT, false, 3, 4499.99,
                new Owner(Gender.FEMALE, "Aleksandra", "Górska"));
        addBike("Trek", "Powerfly FS 9", BikeType.ELECTRIC, true, 0, 11149.99,
                new Owner(Gender.FEMALE, "Katarzyna", "Gawrońska"));
        addBike("Trek", "Boone 6", BikeType.CYCLOCROSS, false, 4, 1899.99,
                new Owner(Gender.MALE, "Krzysztof", "Nasiński"));
        addBike("Trek", "District 4", BikeType.CITY, true, 0, 2699.99,
                new Owner(Gender.FEMALE, "Dorota", "Lewandowska"));
    }
}
