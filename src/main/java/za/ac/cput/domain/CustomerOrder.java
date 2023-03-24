package za.ac.cput.domain;

/* CustomerOrder.java
Entity for the CustomerOrder
Author: David Henriques Garrancho (221475982)
Date: 20 March 2023
*/

import java.util.Objects;

public class CustomerOrder {
    private String orderID;
    private String orderDescription;
    private String dateOfOrder;
    private String paymentMethod;
    public Double totalPrice;
    public String customerID;

    public CustomerOrder() {
    }

    public String getOrderID() {
        return orderID;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public String getDateOfOrder() {
        return dateOfOrder;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public String getCustomerID() {
        return customerID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOrder that = (CustomerOrder) o;
        return Objects.equals(orderID, that.orderID) && Objects.equals(orderDescription, that.orderDescription) && Objects.equals(dateOfOrder, that.dateOfOrder) && Objects.equals(paymentMethod, that.paymentMethod) && Objects.equals(totalPrice, that.totalPrice) && Objects.equals(customerID, that.customerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, orderDescription, dateOfOrder, paymentMethod, totalPrice, customerID);
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "orderID='" + orderID + '\'' +
                ", orderDescription='" + orderDescription + '\'' +
                ", dateOfOrder='" + dateOfOrder + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", totalPrice=" + totalPrice +
                ", customerID='" + customerID + '\'' +
                '}';
    }

    public CustomerOrder(Builder b){
        this.orderID = b.orderID;
        this.orderDescription = b.orderDescription;
        this.dateOfOrder = b.dateOfOrder;
        this.paymentMethod = b.paymentMethod;
        this.totalPrice = b.totalPrice;
        this.customerID = b.customerID;
    }

    public static class Builder{
        private String orderID;
        private String orderDescription;
        private String dateOfOrder;
        private String paymentMethod;
        public Double totalPrice;
        public String customerID;

        public Builder setOrderID(String orderID){
            this.orderID = orderID;
            return this;
        }

        public Builder setOrderDescription(String orderDescription){
            this.orderDescription = orderDescription;
            return this;
        }

        public Builder setDateOfOrder(String dateOfOrder){
            this.dateOfOrder = dateOfOrder;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod){
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setTotalPrice(Double totalPrice){
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder setCustomerID(String customerID){
            this.customerID = customerID;
            return this;
        }

        public Builder copy(CustomerOrder customerOrder){
            this.orderID = customerOrder.customerID;
            this.orderDescription = customerOrder.orderDescription;
            this.dateOfOrder = customerOrder.dateOfOrder;
            this.paymentMethod = customerOrder.paymentMethod;
            this.totalPrice = customerOrder.totalPrice;
            this.customerID = customerOrder.customerID;
            return this;
        }

        public CustomerOrder build(){
            return new CustomerOrder(this);
        }
    }
}
