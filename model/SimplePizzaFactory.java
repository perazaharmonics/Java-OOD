package model;

public class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;
        
        switch (type.toLowerCase()) {
            case "cheese":
                pizza = new CheesePizza("Cheese Pizza", 9.99f, 12, 1);
                break;
            case "pepperoni":
                pizza = new PepperoniPizza("Pepperoni Pizza", 11.99f, 12, 1);
                break;
            case "vegetable":
                pizza = new VegetablePizza("Vegetable Pizza", 10.99f, 12, 1);
                break;
            case "allmeats":
                pizza = new AllMeatsPizza("All Meats Pizza", 12.99f, 12, 1);
                break;
            default:
                throw new IllegalArgumentException("Unknown pizza type: " + type);
        }
        
        return pizza;
    }
}



