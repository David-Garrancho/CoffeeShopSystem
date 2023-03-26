package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;

public class CustomerFactory {
    public static Customer buildCustomer(String firstName, String lastName, String phoneNumber, String email){
        if(Helper.isNullOrEmpty(firstName) == true || Helper.isNullOrEmpty(lastName) == true) {
            return null;
        }

        if(!Helper.isValidEmail(email)){
            return null;
        }

        if(!Helper.isValidPhoneNumber(phoneNumber)){
            return null;
        }

        String customerID = Helper.generateId();

        return new Customer.Builder()
                .setCustomerID(customerID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .build();
    }
}
