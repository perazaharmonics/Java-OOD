package model;




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
        return calculatePriceBasedOnSize();
    }
    private float calculatePriceBasedOnSize() {
        float priceMultiplier = 1.0f;  // default multiplier for standard size

        if(size < 16) {
            priceMultiplier = 0.8f;   // assume smaller pizzas cost 20% less
        } else if(size > 16) {
            priceMultiplier = 1.2f;   // assume larger pizzas cost 20% more
        }

        return price * priceMultiplier;
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



