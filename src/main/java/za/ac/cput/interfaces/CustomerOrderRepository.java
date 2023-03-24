package za.ac.cput.interfaces;

/* CustomerOrdersRepository.java
Class for the CustomerOrdersRepository
Author: David Henriques Garrancho (221475982)
Date: 20 March 2023
*/

import za.ac.cput.domain.CustomerOrder;

import java.util.*;

public class CustomerOrderRepository implements InterfaceCustomerOrdersRepository{

    private Set<CustomerOrder> customerOrderDB = null;
    private static CustomerOrderRepository repository = null;
    private CustomerOrderRepository(){
        customerOrderDB = new HashSet<CustomerOrder>();
    }

    public static CustomerOrderRepository getRepository(){
        if(repository == null){
            repository = new CustomerOrderRepository();
        }
        return repository;
    }

    @Override
    public CustomerOrder create(CustomerOrder customerOrder) {
        boolean success = customerOrderDB.add(customerOrder);
        if(!success){
            return null;
        }
        return customerOrder;
    }

    @Override
    public CustomerOrder read(String orderID) {
        CustomerOrder c = customerOrderDB.stream()
                .filter(e -> e.getOrderID().equals(orderID))
                .findAny()
                .orElse(null);
        return c;
    }

    @Override
    public CustomerOrder update(CustomerOrder customerOrder) {
        CustomerOrder oldCustomerOrder = read(customerOrder.getOrderID());
        if(oldCustomerOrder !=null){
            customerOrderDB.remove(oldCustomerOrder);
            customerOrderDB.add(customerOrder);
            return customerOrder;
        }
        return null;
    }

    @Override
    public boolean delete(String orderID) {
        CustomerOrder customerOrderToDelete = read(orderID);
        if(customerOrderToDelete == null){
            return false;
        }
        customerOrderDB.remove(customerOrderToDelete);
        return true;
    }

    @Override
    public Set<CustomerOrder> getAll() {
        return customerOrderDB;
    }

}
