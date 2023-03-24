package za.ac.cput.interfaces;

/* CustomerRepositoryTest.java
Test Class for the CustomerRepositoryTest
Author: David Henriques Garrancho (221475982)
Date: 22 March 2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class CustomerRepositoryTest {

    private static CustomerRepository repository = CustomerRepository.getRepository();
    private static Customer customer = CustomerFactory.buildCustomer("David", "Garrancho", "0662249965", "gd@gmail.com");

    @Test
    void a_create() {
        Customer created = repository.create(customer);
        assertEquals(customer.getCustomerID(), created.getCustomerID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Customer read = repository.read(customer.getCustomerID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Customer updated = new Customer.Builder().copy(customer)
                .setFirstName("David Henriques")
                .setPhoneNumber("0825214965")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(customer.getCustomerID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}