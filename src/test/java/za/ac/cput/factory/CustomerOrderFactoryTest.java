package za.ac.cput.factory;

/* CustomerOrderFactoryTest.java
Test Class for the CustomerOrderFactory
Author: David Henriques Garrancho (221475982)
Date: 22 March 2023
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.CustomerOrder;

import static org.junit.jupiter.api.Assertions.*;

class CustomerOrderFactoryTest {
    @Test
    void createCustomerOrder(){
        CustomerOrder c = CustomerOrderFactory.buildCustomerOrder("Coffee and Muffin", "29-03-2023", "Cash", 49.99);
        System.out.println(c.toString());
        assertNotNull(c);
    }

    @Test
    void testEmptyParameter(){
        CustomerOrder c = CustomerOrderFactory.buildCustomerOrder("", "22-03-2023", "Cash", 49.99);
        System.out.println(c);
        assertNull(c);
    }

    @Test
    void testEmptyParameter2(){
        CustomerOrder c = CustomerOrderFactory.buildCustomerOrder("Muffin and Coffee", "", "Cash", 49.99);
        assertNull(c);
    }

    @Test
    void testEmptyParameter3(){
        CustomerOrder c = CustomerOrderFactory.buildCustomerOrder("Muffin and Coffee", "22-03-2023", "", 49.99);
        assertNull(c);
    }

    @Test
    void testInvalidParameter(){
        CustomerOrder c = CustomerOrderFactory.buildCustomerOrder("Muffin and Coffee", "22-03-2023", "Cash", -38.00 );
        assertNull(c);
    }

    @Test
    void testInvalidParameter2(){
        CustomerOrder c = CustomerOrderFactory.buildCustomerOrder("Muffin and Coffee", "22-03", "Cash", 38.00 );
        assertNull(c);
    }

    @Test
    void testInvalidParameter3(){
        CustomerOrder c = CustomerOrderFactory.buildCustomerOrder("Muffin and Coffee", "22-March-2023", "Cash", 38.00 );
        assertNull(c);
    }

    @Test
    void testInvalidParameter4(){
        CustomerOrder c = CustomerOrderFactory.buildCustomerOrder("Muffin and Coffee", "30-02-2023", "Cash", 38.00 );
        assertNull(c);
    }

    @Test
    void testEquality(){
        CustomerOrder c = CustomerOrderFactory.buildCustomerOrder("Muffin and Coffee", "22-03-2023", "Cash", 38.99 );
        CustomerOrder c2 = CustomerOrderFactory.buildCustomerOrder("Muffin and Coffee", "22-03-2023", "Cash", 38.99 );
        System.out.println(c.toString());
        System.out.println(c2.toString());
        assertNotEquals(c, c2);
    }

    @Test
    void testEquality2(){
        CustomerOrder c = CustomerOrderFactory.buildCustomerOrder("Muffin and Coffee", "22-03-2023", "Cash", 38.99 );
        CustomerOrder c2 = c;
        System.out.println(c.toString());
        assertEquals(c, c2);
    }

    @Test
    void testEquality3(){
        CustomerOrder c = CustomerOrderFactory.buildCustomerOrder("Muffin and Coffee", "22-03-2023", "Cash", 38.99 );
        CustomerOrder c2 = CustomerOrderFactory.buildCustomerOrder("Muffin and Coffee", "22-03-2023", "Cash", 38.99 );
        System.out.println(c.toString());
        System.out.println(c2.toString());
        assertNotEquals(c, c2);
    }

}