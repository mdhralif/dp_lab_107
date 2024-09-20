public class PayPalPayment implements PaymentMethodStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of: $" + amount);
    }
}
