package factory;

import model.Pizza;

public interface PizzaFactory {
    Pizza createPizza(String title, float price, int size, int orderSize);
}