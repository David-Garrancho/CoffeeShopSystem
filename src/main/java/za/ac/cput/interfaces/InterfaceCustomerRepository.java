package za.ac.cput.interfaces;

/* InterfaceCustomerRepository.java
Class for the CustomerRepository
Author: David Henriques Garrancho (221475982)
Date: 20 March 2023
*/

import za.ac.cput.domain.Customer;

import java.util.Set;

public interface InterfaceCustomerRepository extends InterfaceRepository<Customer, String> {

    public Set<Customer> getAll();
}
