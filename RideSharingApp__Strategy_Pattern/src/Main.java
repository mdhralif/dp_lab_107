import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a rider
        System.out.print("Enter rider name: ");
        String riderName = scanner.nextLine();
        Rider rider = new Rider(riderName, "123 Main St");

        // Create a driver (driver logic is hidden from the rider)
        Driver driver = new Driver("Bob", "Sedan", 4.8);

        while (true) {
            // Select Ride Type
            System.out.println("\nSelect Ride Type: ");
            System.out.println("1. Carpool");
            System.out.println("2. Luxury Ride");
            int rideChoice = scanner.nextInt();

            RideTypeStrategy rideType;
            if (rideChoice == 1) {
                rideType = new CarpoolRide();
            } else {
                rideType = new LuxuryRide();
            }

            // Set base fare for the selected ride type
            double baseFare = (rideChoice == 1) ? 10.0 : 20.0;

            // Create a trip
            Trip trip = new Trip(rider, driver, rideType, baseFare);

            // Driver accepts the ride
            driver.acceptRide(rider, trip);

            // Driver starts the trip
            driver.startTrip();

            // Ask for distance
            System.out.print("Enter trip distance (km): ");
            double distance = scanner.nextDouble();

            // Select Payment Method
            System.out.println("Select Payment Method: ");
            System.out.println("1. Credit Card");
            System.out.println("2. PayPal");
            int paymentChoice = scanner.nextInt();

            if (paymentChoice == 1) {
                rider.setPreferredPaymentMethod(new CreditCardPayment());
            } else {
                rider.setPreferredPaymentMethod(new PayPalPayment());
            }

            // Select Notification Method
            System.out.println("Select Notification Method: ");
            System.out.println("1. SMS");
            System.out.println("2. Email");
            int notificationChoice = scanner.nextInt();

            if (notificationChoice == 1) {
                rider.setPreferredNotificationMethod(new SMSNotification());
            } else {
                rider.setPreferredNotificationMethod(new EmailNotification());
            }

            // Rider requests the trip and completes it
            rider.requestRide(trip, distance);

            // Ask if the rider wants to book another ride
            System.out.print("\nWould you like to book another ride? (yes/no): ");
            scanner.nextLine();  // Consume the newline character
            String continueRide = scanner.nextLine();
            if (continueRide.equalsIgnoreCase("no")) {
                break;
            }
        }

        scanner.close();
    }
}