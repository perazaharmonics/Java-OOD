package strategy;


public class InStorePickupFee implements DeliveryFeeStrategy {
    @Override
    public double calculateDeliveryFee(double basePrice) {
        // No additional fee for in-store pickup clients
        return 0;
    }
}
