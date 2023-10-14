package IOutletFactory;

import factory.PizzaFactory;

public interface OutletFactory {
    PizzaFactory getPizzaFactory(String type);
}