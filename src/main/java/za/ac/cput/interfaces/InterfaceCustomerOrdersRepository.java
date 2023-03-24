package za.ac.cput.interfaces;

/* InterfaceCustomerOrdersRepository.java
Class for the CustomerRepository
Author: David Henriques Garrancho (221475982)
Date: 20 March 2023
*/

import za.ac.cput.domain.CustomerOrder;

import java.util.Set;

public interface InterfaceCustomerOrdersRepository extends InterfaceRepository<CustomerOrder, String> {

    public Set<CustomerOrder> getAll();
}
