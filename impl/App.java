package impl;

import pizzaFactory.PizzaOrderFacade;
public class App {
	

	public class Main {
	    public static void main(String[] args) {
	        // Using Facade to order pizza
	        PizzaOrderFacade pizzaOrder = new PizzaOrderFacade();
	        
	        // Ordering Italian Thin Crust Pizza
	        pizzaOrder.orderItalianThinCrustPizza("Margherita", 17.99f, 16, 1);

	        // Ordering American Thick Crust Pizza
	        pizzaOrder.orderAmericanThickCrustPizza("Pepperoni", 19.99f, 18, 1);
	    }
	}


}
