package no.hvl.dat250.jpa.assignment2.driver;

import no.hvl.dat250.jpa.assignment2.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
    public static final String PERSISTENCE_UNIT_NAME = "experiment2";
    private static Person person;
    private static Pincode pincode;
    private static CreditCard c1;
    private static CreditCard c2;
    private static Bank bank;
    private static Address address;

    private static void initializeData() {
        // Declare person
        person = new Person();
        person.setName("Max Mustermann");

        // Declare Address
        address = new Address();
        address.setStreet("Inndalsveien");
        address.setNumber(28);

        // Declare Bank
        bank = new Bank();
        bank.setName("Pengebank");

        // Declare Credit card 1
        c1 = new CreditCard();
        c1.setNumber(12345);
        c1.setBalance(-5000);
        c1.setLimit(-10000);

        // Declare Credit card 2
        c2 = new CreditCard();
        c2.setNumber(123);
        c2.setBalance(1);
        c2.setLimit(2000);

        // Declare Pincode
        pincode = new Pincode();
        pincode.setPincode("123");
        pincode.setCount(1);

        // Establish relations
        Set<Address> l = new HashSet<>();
        l.add(address);
        person.setAddresses(l);

        Set<Person> persons = new HashSet<>();
        persons.add(person);
        address.setOwners(persons);

        c1.setPincode(pincode);
        c2.setPincode(pincode);

        c1.setOwningBank(bank);
        c2.setOwningBank(bank);


        Set <CreditCard> creditCards = new HashSet<>();
        creditCards.add(c1);
        creditCards.add(c2);
        bank.setOwnedCards(creditCards);
        person.setCreditCards(creditCards);
    }

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // Declare persistent objects
        initializeData();

        // Begin Transaction
        em.getTransaction().begin();

        em.persist(person);
        em.persist(address);
        em.persist(c1);
        em.persist(c2);
        em.persist(bank);
        em.persist(pincode);

        em.getTransaction().commit();

        em.close();

    }
}
