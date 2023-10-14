package facade;

import model.SimplePizzaFactory;
import CalculationSingleton.CalculationSingleton;
import model.Pizza;
import strategy.DeliveryFeeStrategy;

public class PizzaOrderFacade {
    private SimplePizzaFactory pizzaFactory;
    private CalculationSingleton calculator;
    private double totalPrice;

    public PizzaOrderFacade() {
        pizzaFactory = new SimplePizzaFactory();
        calculator = CalculationSingleton.getInstance();
        totalPrice = 0;
    }

    public PizzaOrderFacade(DeliveryFeeStrategy strategy) {
        calculator = CalculationSingleton.getInstance();
        calculator.setDeliveryFeeStrategy(strategy);
    }
    
    // Modified to accept and handle pizza sizes
    public void orderPizza(String type, int size) {
        Pizza pizza = pizzaFactory.createPizza(type);
        
        // Assuming you have a method to set the size of the pizza
        pizza.setSize(size);

        // Recalculate the price based on size, this is just a placeholder
        // You should replace this with your actual logic to calculate the price based on size
        float newPrice = pizza.getPrice() * size / 10; // Placeholder calculation
        pizza.setPrice(newPrice);

        totalPrice = calculator.calculateTotalPrice(pizza);  
        System.out.println(pizza + " ordered and the total price is $" + totalPrice);
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
