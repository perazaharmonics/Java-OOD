package Calculation;
import pizzaFactory.Pizza;
public class CalculationSingleton {

    private static CalculationSingleton instance;

    private CalculationSingleton() {
        // private constructor to restrict instantiation
    }

    public static CalculationSingleton getInstance() {
        if (instance == null) {
            instance = new CalculationSingleton();
        }
        return instance;
    }

    public double calculateTotalPrice(Pizza pizza) {
        
    
    	
        return pizza.getPrice() * pizza.getOrderSize();
    }

    
}