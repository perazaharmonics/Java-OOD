package strategy;

public class OnlineDeliveryFee implements DeliveryFeeStrategy {
    @Override
    public double calculateDeliveryFee(double basePrice) {
        // For example, a 10% delivery fee for online clients
        return basePrice + 5;
    }
}
