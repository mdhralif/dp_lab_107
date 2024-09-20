public class Trip {
    private RideTypeStrategy rideTypeStrategy;
    private PaymentMethodStrategy paymentMethodStrategy;
    private NotificationStrategy notificationStrategy;
    private double baseFare;
    private Rider rider;
    private Driver driver;

    public Trip(Rider rider, Driver driver, RideTypeStrategy rideTypeStrategy, double baseFare) {
        this.rider = rider;
        this.driver = driver;
        this.rideTypeStrategy = rideTypeStrategy;
        this.baseFare = baseFare;
    }

    public void setPaymentMethod(PaymentMethodStrategy paymentMethodStrategy) {
        this.paymentMethodStrategy = paymentMethodStrategy;
    }

    public void setNotificationMethod(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    public double calculateFare(double distance) {
        return rideTypeStrategy.calculateFare(distance, baseFare);
    }

    public void completeTrip(double fare) {
        System.out.println("Completing trip...");
        driver.completeTrip();
        paymentMethodStrategy.processPayment(fare);
    }

    public void sendTripNotification(String message) {
        notificationStrategy.sendNotification(message);
    }
}
