package CalculationSingleton;

import model.Pizza;
import strategy.DeliveryFeeStrategy;

public class CalculationSingleton {

    private static CalculationSingleton instance;
    private DeliveryFeeStrategy deliveryFeeStrategy;

    private CalculationSingleton() {
    }

    public static CalculationSingleton getInstance() {
        if (instance == null) {
            instance = new CalculationSingleton();
        }
        return instance;
    }

    public void setDeliveryFeeStrategy(DeliveryFeeStrategy strategy) {
        this.deliveryFeeStrategy = strategy;
    }

    public double calculateTotalPrice(Pizza pizza) {
        double totalPrice = pizza.getPrice() * pizza.getOrderSize();
        if (deliveryFeeStrategy != null) {
            totalPrice += deliveryFeeStrategy.calculateDeliveryFee(totalPrice);
        }
        return totalPrice;
}
}
