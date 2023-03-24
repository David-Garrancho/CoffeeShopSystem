package za.ac.cput.factory;

/* CustomerFactoryTest.java
Test Class for the CustomerFactory
Author: David Henriques Garrancho (221475982)
Date: 22 March 2023
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {
    @Test
    void createCustomer(){
        Customer c = CustomerFactory.buildCustomer("David", "Garrancho", "0662249965", "gd@gmail.com");
        System.out.println(c.toString());
        assertNotNull(c);
    }

    @Test
    void testEmptyParameter(){
        Customer c = CustomerFactory.buildCustomer("David", "", "0662249965", "gd@gmail.com");
        assertNull(c);
    }

    @Test
    void testEmptyParameter2(){
        Customer c = CustomerFactory.buildCustomer("", "Garrancho", "0662249965", "gd@gmail.com");
        assertNull(c);
    }

    @Test
    void testEmptyParameter3(){
        Customer c = CustomerFactory.buildCustomer("David", "Garrancho", "", "gd@gmail.com");
        assertNull(c);
    }

    @Test
    void testEmptyParameter4(){
        Customer c = CustomerFactory.buildCustomer("David", "Garrancho", "0662249965", "");
        assertNull(c);
    }

    @Test
    void testInvalidParameter(){
        Customer c = CustomerFactory.buildCustomer("David", "Garrancho", "0662249965", "gd@gmail");
        assertNull(c);
    }

    @Test
    void testInvalidParameter2(){
        Customer c = CustomerFactory.buildCustomer("David", "Garrancho", "066224efgs", "gd@gmail.com");
        assertNull(c);
    }

    @Test
    void testInvalidParameter3(){
        Customer c = CustomerFactory.buildCustomer("David", "Garrancho", "066", "gd@gmail.com");
        assertNull(c);
    }

    @Test
    void testEquality(){
        Customer c = CustomerFactory.buildCustomer("David", "Garrancho", "0662249965", "gd@gmail.com");
        Customer c2 = CustomerFactory.buildCustomer("David", "Garrancho", "0662249965", "gd@gmail.com");
        System.out.println(c.toString());
        System.out.println(c2.toString());
        assertNotEquals(c, c2);
    }

    @Test
    void testEquality3(){
        Customer c = CustomerFactory.buildCustomer("David", "Garrancho", "0662249965", "gd@gmail.com");
        Customer c2 = c;
        System.out.println(c.toString());
        assertEquals(c, c2);
    }

}