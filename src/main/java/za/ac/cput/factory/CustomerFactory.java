package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.util.CustomerHelper;

public class CustomerFactory {
    public static Customer buildCustomer(String firstName, String lastName, String phoneNumber, String email){
        if(CustomerHelper.isNullOrEmpty(firstName) == true || CustomerHelper.isNullOrEmpty(lastName) == true) {
            return null;
        }

        if(!CustomerHelper.isValidEmail(email)){
            return null;
        }

        if(!CustomerHelper.isValidPhoneNumber(phoneNumber)){
            return null;
        }

        String customerID = CustomerHelper.generateId();

        return new Customer.Builder()
                .setCustomerID(customerID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .build();
    }
}
