package impl;

import facade.PizzaOrderFacade;
import dao.ClientDAO;
import dao.InStoreDAO;
import dao.OnlineClientDAO;
import model.Client;
import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {
        try {
            // Create a Scanner object to read user input
            Scanner scanner = new Scanner(System.in);

            // Asking the user for the type of order
            System.out.println("Is this an online order or in-store pickup? (Enter 'online' or 'in-store')");
            String orderType = scanner.nextLine();

            ClientDAO clientDAO;
            String name, address = "";

            // Asking the user for their name
            System.out.println("Please enter your name:");
            name = scanner.nextLine();

            if (orderType.equalsIgnoreCase("online")) {
                // Asking the user for their address if it's an online order
                System.out.println("Please enter your address:");
                address = scanner.nextLine();
                clientDAO = new OnlineClientDAO();
            } else if (orderType.equalsIgnoreCase("in-store")) {
                clientDAO = new InStoreDAO();
            } else {
                System.out.println("Invalid option. Please start over and enter a valid order type.");
                return;
            }

            // Asking the user for the type of pizza
            System.out.println("Please enter the type of pizza you would like to order:");
            String pizzaType = scanner.nextLine();
            // Asking the user for the size of pizza
            System.out.println("Please enter the size of the pizza you would like to order:");
            int size;
            try {
                size = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid size entered. Please enter a valid number for the size.");
                return;
            }
            // Using Facade to order pizza
            PizzaOrderFacade pizzaOrder = new PizzaOrderFacade();

            // Ordering pizza based on user input
            pizzaOrder.orderPizza(pizzaType, size);

            // Adding the client to DAO
            Client client = new Client(name, address, 1, pizzaOrder.getTotalPrice()); // Adjust the constructor accordingly
            clientDAO.addClient(client);

            if (orderType.equalsIgnoreCase("online")) {
                System.out.println("Thank you for your order, " + name + "! Your order is on the way to " + address);
            } else {
                System.out.println("Thank you for your order, " + name + "! Your order will be ready for pickup shortly.");
            }

            // Close the scanner object to prevent resource leak
            scanner.close();

        } catch (InputMismatchException ime) {
            System.err.println("Input mismatch error: " + ime.getMessage());
        } catch (NullPointerException npe) {
            System.err.println("Null pointer error: " + npe.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
