package model;

public class Client {
    private String name;
    private String address;
    private int orderNumber;
    private double orderTotal;

    // New constructor that accepts four parameters
    public Client(String name, String address, int orderNumber, double orderTotal) {
        this.name = name;
        this.address = address;
        this.orderNumber = orderNumber;
        this.orderTotal = orderTotal;
    }


    // Existing or new getters and setters for these fields

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }
}