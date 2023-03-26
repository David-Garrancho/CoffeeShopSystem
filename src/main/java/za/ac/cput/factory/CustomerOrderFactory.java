package za.ac.cput.factory;

import za.ac.cput.domain.CustomerOrder;
import za.ac.cput.util.Helper;

public class CustomerOrderFactory {
    public static CustomerOrder buildCustomerOrder(String orderDescription, String dateOfOrder, String paymentMethod, Double totalPrice) {

        if (Helper.isNullOrEmpty(orderDescription) == true || Helper.isNullOrEmpty(paymentMethod) == true || Helper.isInvalidDouble(totalPrice) == true) {
            return null;
        }

        if (Helper.isValidDate(dateOfOrder) == null) {
            return null;
        }

        String customerID = Helper.generateId();

        String orderID = Helper.generateId();

        return new CustomerOrder.Builder()
                .setOrderID(orderID)
                .setOrderDescription(orderDescription)
                .setDateOfOrder(dateOfOrder)
                .setPaymentMethod(paymentMethod)
                .setTotalPrice(totalPrice)
                .setCustomerID(customerID)
                .build();
    }
}
