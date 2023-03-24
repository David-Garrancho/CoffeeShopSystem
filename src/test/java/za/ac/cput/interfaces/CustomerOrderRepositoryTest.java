package za.ac.cput.interfaces;

/* CustomerOrderRepositoryTest.java
Test Class for the CustomerOrderRepositoryTest
Author: David Henriques Garrancho (221475982)
Date: 22 March 2023
*/

import org.junit.jupiter.api.*;
import za.ac.cput.domain.CustomerOrder;
import za.ac.cput.factory.CustomerOrderFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class CustomerOrderRepositoryTest {

    private static CustomerOrderRepository repository = CustomerOrderRepository.getRepository();
    private static CustomerOrder customerOrder = CustomerOrderFactory.buildCustomerOrder("Coffee with milk and cookie", "23-03-2023", "Card", 25.50);

    @Test
    void a_create() {
        CustomerOrder created = repository.create(customerOrder);
        assertEquals(customerOrder.getOrderID(), created.getOrderID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        CustomerOrder read = repository.read(customerOrder.getOrderID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        CustomerOrder updated = new CustomerOrder.Builder().copy(customerOrder)
                .setOrderDescription("Coffee with milk")
                .setTotalPrice(12.50)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(customerOrder.getOrderID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}