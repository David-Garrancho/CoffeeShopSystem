package za.ac.cput.factory;

import za.ac.cput.domain.CustomerOrder;
import za.ac.cput.util.CustomerHelper;
import za.ac.cput.util.CustomerOrderHelper;

import java.util.*;

public class CustomerOrderFactory {
    public static CustomerOrder buildCustomerOrder(String orderDescription, String dateOfOrder, String paymentMethod, Double totalPrice) {

        if (CustomerOrderHelper.isNullOrEmpty(orderDescription) == true || CustomerOrderHelper.isNullOrEmpty(paymentMethod) == true || CustomerOrderHelper.isInvalidDouble(totalPrice)) {
            return null;
        }

        if(CustomerOrderHelper.isValidDate(dateOfOrder) == null){
            return null;
        }

        String customerID = CustomerHelper.generateId();

        String orderID = CustomerOrderHelper.generateId();

        return new CustomerOrder.Builder().setOrderID(orderID)
                .setOrderDescription(orderDescription)
                .setDateOfOrder(dateOfOrder)
                .setPaymentMethod(paymentMethod)
                .setTotalPrice(totalPrice)
                .setCustomerID(customerID)
                .build();
    }
}
