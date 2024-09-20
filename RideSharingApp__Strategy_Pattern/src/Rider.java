public class Rider {
    private String name;
    private String location;
    private PaymentMethodStrategy preferredPaymentMethod;
    private NotificationStrategy preferredNotificationMethod;

    public Rider(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setPreferredPaymentMethod(PaymentMethodStrategy paymentMethod) {
        this.preferredPaymentMethod = paymentMethod;
    }

    public void setPreferredNotificationMethod(NotificationStrategy notificationMethod) {
        this.preferredNotificationMethod = notificationMethod;
    }

    public void requestRide(Trip trip, double distance) {
        // Calculate fare for the trip
        double fare = trip.calculateFare(distance);
        System.out.println(name + " requested a ride. Estimated fare: $" + fare);

        // Complete the trip and process payment using preferred method
        trip.setPaymentMethod(preferredPaymentMethod);
        trip.completeTrip(fare);

        // Send notification via preferred method
        trip.setNotificationMethod(preferredNotificationMethod);
        trip.sendTripNotification("Your trip has been completed.");
    }
}