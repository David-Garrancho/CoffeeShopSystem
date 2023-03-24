package za.ac.cput.domain;

/* Customer.java
Entity for the Customer
Author: David Henriques Garrancho (221475982)
Date: 20 March 2023
*/

import java.util.Objects;

public class Customer {
    private String customerID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    private Customer(){
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerID, customer.customerID) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(phoneNumber, customer.phoneNumber) && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID, firstName, lastName, phoneNumber, email);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    private Customer(Builder b){
        this.customerID = b.customerID;
        this.firstName = b.firstName;
        this.lastName = b.lastName;
        this.phoneNumber = b.phoneNumber;
        this.email = b.email;
    }

    public static class Builder {
        private String customerID;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String email;

        public Builder setCustomerID(String customerID){
            this.customerID = customerID;
            return this;
        }

        public Builder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setEmail(String email){
            this.email = email;
            return this;
        }

        public Builder copy(Customer customer){
            this.customerID = customer.customerID;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.phoneNumber = customer.phoneNumber;
            this.email = customer.email;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }
}
