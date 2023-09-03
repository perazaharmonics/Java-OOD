package com.example.pizza;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PizzaPlace ppce = new PizzaPlace();
        ArrayList<Order> orders = new ArrayList<>();
        
        // Adding Pizza to the menu
        // Adding Pizza to the menu
        ppce.addPizza(new Pizza("Cheese", 16.99f, 16, 1));
        ppce.addPizza(new Pizza("Pepperoni", 17.99f, 16, 1));
        ppce.addPizza(new Pizza("Hawaiian", 16.99f, 16, 1));


        while (true) {
            System.out.println("Welcome to the Pizza Delivery Service!");
            System.out.println("Available Pizzas:");
            for (int i = 0; i < ppce.getSize(); ++i) {
                System.out.println(i + 1 + ". " + ppce.getPizza(i).Title);
            }

            System.out.print("Select a pizza (1-" + ppce.getSize() + "): ");
            int pizzaChoice = scanner.nextInt();
            if (pizzaChoice < 1 || pizzaChoice > ppce.getSize()) {
                System.out.println("Invalid choice. Please select a valid pizza.");
                continue;
            }

            Pizza selectedPizza = ppce.getPizza(pizzaChoice - 1);
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            System.out.print("Enter your name: ");
            scanner.nextLine(); // Consume the newline character
            String name = scanner.nextLine();

            System.out.print("Enter your address: ");
            String address = scanner.nextLine();

            System.out.print("Enter your phone number: ");
            String phone = scanner.nextLine();

            System.out.println("Order Summary:");
            System.out.println("Pizza: " + selectedPizza.Title);
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Price: $" + (selectedPizza.Price * quantity));
            System.out.println("Delivery Address: " + address);

            System.out.print("Confirm order? (yes/no): ");
            String confirm = scanner.next();
            if (confirm.equalsIgnoreCase("yes")) {
                Order order = new Order(name, address, phone, selectedPizza, quantity);
                orders.add(order);
                System.out.println("Order confirmed!");
            } else {
                System.out.println("Order cancelled.");
            }

            System.out.print("Place another order? (yes/no): ");
            String anotherOrder = scanner.next();
            if (!anotherOrder.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Order History:");
        for (Order order : orders) {
            System.out.println(order);
        }

        System.out.println("Thank you for using our Pizza Delivery Service!");
        scanner.close();
    }
}

class Order {
    String name;
    String address;
    String phone;
    Pizza pizza;
    int quantity;

    public Order(String name, String address, String phone, Pizza pizza, int quantity) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.pizza = pizza;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Customer: " + name + "\n"
                + "Pizza: " + pizza.Title + "\n"
                + "Quantity: " + quantity + "\n"
                + "Total Price: $" + (pizza.Price * quantity) + "\n"
                + "Delivery Address: " + address + "\n"
                + "Phone: " + phone + "\n";
    }
}
