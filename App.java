package pizzaSingleton;

abstract class Pizza {
    protected String Title;
    protected float Price;
    protected int Size;
    protected int Order_Size; 

    // Default constructor
    public Pizza() {
        Title = "";
        Price = 16.99f;
        Size = 16;
        Order_Size = 1;
    }

    // Parameterized constructor
    public Pizza(String title, float price, int size, int order_size) {
        this.Title = title;
        this.Price = price;
        this.Size = size;
        this.Order_Size = order_size;
    }
}
//Abstract Factory of Factories
interface OutletFactory {
 PizzaFactory getPizzaFactory(String type);
}

//Abstract Factory
interface PizzaFactory {
 Pizza createPizza(String title, float price, int size, int orderSize);
}

//Concrete Factory of Factories
class ItalianPizzaOutlet implements OutletFactory {
 @Override
 public PizzaFactory getPizzaFactory(String type) {
     if ("ThinCrust".equalsIgnoreCase(type)) {
         return new ItalianThinCrustPizzaFactory();
     } else if ("ThickCrust".equalsIgnoreCase(type)) {
         return new ItalianThickCrustPizzaFactory();
     }
     return null;
 }
}

class AmericanPizzaOutlet implements OutletFactory {
 @Override
 public PizzaFactory getPizzaFactory(String type) {
     if ("ThinCrust".equalsIgnoreCase(type)) {
         return new AmericanThinCrustPizzaFactory();
     } else if ("ThickCrust".equalsIgnoreCase(type)) {
         return new AmericanThickCrustPizzaFactory();
     }
     return null;
 }
}

//Concrete Factories
class ItalianThinCrustPizzaFactory implements PizzaFactory {
 @Override
 public Pizza createPizza(String title, float price, int size, int orderSize) {
     // Italian style thin crust pizza creation logic
     return new ThinCrustPizza(title, price, size, orderSize); 
 }
}

class ItalianThickCrustPizzaFactory implements PizzaFactory {
 @Override
 public Pizza createPizza(String title, float price, int size, int orderSize) {
     // Italian style thick crust pizza creation logic
     return new ThickCrustPizza(title, price, size, orderSize);
 }
}

class AmericanThinCrustPizzaFactory implements PizzaFactory {
 @Override
 public Pizza createPizza(String title, float price, int size, int orderSize) {
     // American style thin crust pizza creation logic
     return new ThinCrustPizza(title, price, size, orderSize);
 }
}

class AmericanThickCrustPizzaFactory implements PizzaFactory {
 @Override
 public Pizza createPizza(String title, float price, int size, int orderSize) {
     // American style thick crust pizza creation logic
     return new ThickCrustPizza(title, price, size, orderSize);
 }
}


//Concrete Products (unchanged from the previous example)
class ThinCrustPizza extends Pizza {
    // Attributes unique to ThinCrustPizza, if any
    private boolean hasCornMealBase;

    public ThinCrustPizza(String title, float price, int size, int orderSize) {
        super(title, price, size, orderSize);
        this.hasCornMealBase = true;  // Let's assume all thin crust pizzas have a cornmeal base
    }

    public boolean hasCornMealBase() {
        return hasCornMealBase;
    }

    public void setHasCornMealBase(boolean hasCornMealBase) {
        this.hasCornMealBase = hasCornMealBase;
    }
    
    // You can add more methods or override the parent methods if required.
}

class ThickCrustPizza extends Pizza {
    // Attributes unique to ThickCrustPizza, if any
    private String crustType;

    public ThickCrustPizza(String title, float price, int size, int orderSize) {
        super(title, price, size, orderSize);
        this.crustType = "Pan";  // Let's assume the default thick crust type is "Pan"
    }

    public String getCrustType() {
        return crustType;
    }

    public void setCrustType(String crustType) {
        this.crustType = crustType;
    }
}
public class App {
 public static void main(String[] args) {
     OutletFactory italianOutlet = new ItalianPizzaOutlet();
     PizzaFactory thinCrustFactory = italianOutlet.getPizzaFactory("ThinCrust");
     Pizza italianThinPizza = thinCrustFactory.createPizza("Margherita", 17.99f, 16, 1);

     OutletFactory americanOutlet = new AmericanPizzaOutlet();
     PizzaFactory thickCrustFactory = americanOutlet.getPizzaFactory("ThickCrust");
     Pizza americanThickPizza = thickCrustFactory.createPizza("Pepperoni", 19.99f, 18, 1);
 }
}

