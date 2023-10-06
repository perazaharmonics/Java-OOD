package pizzaFactory;

public abstract class Pizza implements Cloneable {
    private String title;
    private float price;
    private int size;
    private int orderSize; 

    // Default constructor
    public Pizza() {
        title = "";
        price = 16.99f;
        size = 16;
        orderSize = 1;
    }

    // Parameterized constructor
    public Pizza(String title, float price, int size, int orderSize) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.orderSize = orderSize;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getOrderSize() {
        return orderSize;
    }

    public void setOrderSize(int orderSize) {
        this.orderSize = orderSize;
    }

    
    @Override
    public String toString() {
        return "Pizza [Title=" + title + ", Price=" + price + ", Size=" + size 
                + ", Order Size=" + orderSize + "]";
    }
}

interface PizzaFactory {
    Pizza createPizza(String title, float price, int size, int orderSize);
}

interface OutletFactory {
    PizzaFactory getPizzaFactory(String type);
}

class ItalianPizzaOutlet implements OutletFactory {
    @Override
    public PizzaFactory getPizzaFactory(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }

        switch(type.toLowerCase()) {
            case "thincrust":
                return new ItalianThinCrustPizzaFactory();
            case "thickcrust":
                return new ItalianThickCrustPizzaFactory();
            default:
                throw new IllegalArgumentException("Unknown pizza type: " + type);
        }
    }
}

class AmericanPizzaOutlet implements OutletFactory {
    @Override
    public PizzaFactory getPizzaFactory(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }

        switch(type.toLowerCase()) {
            case "thincrust":
                return new AmericanThinCrustPizzaFactory();
            case "thickcrust":
                return new AmericanThickCrustPizzaFactory();
            default:
                throw new IllegalArgumentException("Unknown pizza type: " + type);
        }
    }
}


//Concrete Factories
class ItalianThinCrustPizzaFactory implements PizzaFactory {
 @Override
 public Pizza createPizza(String title, float price, int size, int orderSize) {
     // Italian style thin crust pizza creation 
     return new ThinCrustPizza(title, price, size, orderSize); 
 }
}

class ItalianThickCrustPizzaFactory implements PizzaFactory {
 @Override
 public Pizza createPizza(String title, float price, int size, int orderSize) {
     // Italian style thick crust pizza creation 
     return new ThickCrustPizza(title, price, size, orderSize);
 }
}

class AmericanThinCrustPizzaFactory implements PizzaFactory {
 @Override
 public Pizza createPizza(String title, float price, int size, int orderSize) {
     // American style thin crust pizza creation
     return new ThinCrustPizza(title, price, size, orderSize);
 }
}

class AmericanThickCrustPizzaFactory implements PizzaFactory {
 @Override
 public Pizza createPizza(String title, float price, int size, int orderSize) {
     // American style thick crust pizza creation 
     return new ThickCrustPizza(title, price, size, orderSize);
 }
}


//Concrete Products 
class ThinCrustPizza extends Pizza {
    
	// Attributes unique to ThinCrustPizza
    private boolean hasCornMealBase;

    public ThinCrustPizza(String title, float price, int size, int orderSize) {
        super(title, price, size, orderSize);
        this.hasCornMealBase = true;  
    }

    public boolean hasCornMealBase() {
        return hasCornMealBase;
    }

    public void setHasCornMealBase(boolean hasCornMealBase) {
        this.hasCornMealBase = hasCornMealBase;
    }
    
    @Override
    public String toString() {
        return "ThinCrustPizza [Title=" + getTitle() 
                + ", Price=" + getPrice() 
                + ", Size=" + getSize() 
                + ", Order Size=" + getOrderSize() 
                + ", Has Corn Meal Base=" + hasCornMealBase() + "]";
    }
    
    @Override
    public Pizza clone() {
        try {
            return (Pizza) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();  // Can't happen as we implement Cloneable
        }
    }
    }
    
    



class ThickCrustPizza extends Pizza {
    // Attributes unique to ThickCrustPizza
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

