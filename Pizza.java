package com.example.pizza;

class Pizza {
    public String Title;
    public float Price;
    public int Size;
    public int Order_Size; // Assuming you intended to add this field

    // Default constructor
    public Pizza() {
        Title = "";
        Price = 16.99f; // Use 'f' to indicate it's a float
        Size = 16;
        Order_Size = 1;
    }

    // Parameterized constructor
    public Pizza(String title, float price, int size, int order_size) {
        Title = title;
        Price = price;
        Size = size;
        Order_Size = order_size;
    }
}