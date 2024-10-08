import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RideSharingApp {
    private BufferedReader reader;

    public RideSharingApp() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() throws IOException {
        System.out.println("Welcome to the Ride-Sharing App!");

        // Get user details
        System.out.print("Enter Rider ID: ");
        int riderId = Integer.parseInt(reader.readLine());

        System.out.print("Enter Rider Name: ");
        String riderName = reader.readLine();

        Rider rider = new Rider(riderId, riderName, null, null);

        // Start the ride request process
        requestRide(rider);
    }

    private IPaymentMethod getPaymentMethod() throws IOException {
        System.out.println("Select Payment Method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.println("3. Digital Wallet");
        System.out.print("Enter your choice: ");
        String choice = reader.readLine();

        switch (choice) {
            case "1":
                System.out.print("Enter Card Number: ");
                int cardNumber = Integer.parseInt(reader.readLine());
                System.out.print("Enter Card Holder Name: ");
                String cardHolderName = reader.readLine();
                return new CreditCardPayment(cardNumber, cardHolderName);

            case "2":
                System.out.print("Enter PayPal Email: ");
                String email = reader.readLine();
                System.out.print("Enter OTP: ");
                int otpPayPal = Integer.parseInt(reader.readLine());
                return new PayPalPayment(email, otpPayPal);

            case "3":
                System.out.print("Enter Wallet ID: ");
                String walletId = reader.readLine();
                System.out.print("Enter OTP: ");
                int otpWallet = Integer.parseInt(reader.readLine());
                return new DigitalWalletPayment(walletId, otpWallet);

            default:
                System.out.println("Invalid payment method selected. Please choose again.");
                return getPaymentMethod(); // Recursive call for invalid selection
        }
    }

    private void requestRide(Rider rider) throws IOException {
        try {
            // Get ride details
            System.out.print("Enter Pickup Location: ");
            String pickupLocation = reader.readLine();

            System.out.print("Enter Drop-off Location: ");
            String dropOffLocation = reader.readLine();

            System.out.print("Enter Distance (in km): ");
            double distance = Double.parseDouble(reader.readLine());

            System.out.println("Select Ride Type:");
            System.out.println("1. Carpool");
            System.out.println("2. Luxury");
            System.out.println("3. Bike");
            System.out.print("Enter your choice: ");
            RideType rideType = RideType.values()[Integer.parseInt(reader.readLine()) - 1];

            // Ask for payment method before starting the journey
            System.out.println("Please select a payment method before starting the journey:");
            rider.changePaymentMethod(getPaymentMethod());

            // Create a new trip with the provided details
            Trip trip = new Trip(1, pickupLocation, dropOffLocation, rideType, distance);

            // Assign a driver (simulated)
            Driver driver = new Driver(1, "John Doe", "Current Location", "Luxury Car");
            trip.assignDriver(driver);

            // Start the trip
            trip.startTrip();

            // Simulating journey time
            Thread.sleep(5000); // Simulate a delay for 5 seconds
            System.out.println("Journey is in progress...");

            // Offer to change payment method during the ride
            System.out.print("Do you want to change your payment method? (yes/no): ");
            if (reader.readLine().equalsIgnoreCase("yes")) {
                changePaymentMethod(rider);
            }

            // Completing the trip
            trip.completeTrip();

            System.out.println("The calculated fare based on distance is " + trip.getFare() + ".");

            // Handle payment with validation
            handlePayment(trip.getFare());

            // Rate the driver
            System.out.print("Rate the driver (1 to 5): ");
            double rating = Double.parseDouble(reader.readLine());
            rider.rateDriver(driver, rating);

            // Decorative line and thank you message
            System.out.println("\n###############################################################################");
            System.out.println("You have completed your journey from " + pickupLocation + " to " + dropOffLocation + " and paid " + trip.getFare() + ".");
            System.out.println("Thank you for using our Ride-Sharing App! Your journey has been completed.");
            System.out.println("We hope to see you again soon!\n");
            System.out.println("###############################################################################");

        } catch (InterruptedException e) {
            System.out.println("The journey was interrupted. Please try again.");
            // Handle any cleanup or state reset here if necessary
        }
    }

    private void handlePayment(double fare) throws IOException {
        double amountPaid;
        while (true) {
            System.out.print("How much did you pay? ");
            amountPaid = Double.parseDouble(reader.readLine());

            if (amountPaid < fare) {
                System.out.println("Payment failed: Insufficient amount. Please pay the required fare.");
            } else if (amountPaid > fare) {
                double extraAmount = amountPaid - fare;
                System.out.println("Payment successful! You have overpaid by " + extraAmount + ". Returning the extra amount...");
                System.out.println("You paid the correct fare of " + fare + ".");
                break;
            } else {
                System.out.println("Payment successful! You paid the correct amount.");
                break;
            }
        }
    }

    private void changePaymentMethod(Rider rider) throws IOException {
        System.out.println("Select Payment Method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.println("3. Digital Wallet");
        System.out.print("Enter your choice: ");
        String paymentChoice = reader.readLine();

        if (paymentChoice.equals("1")) {
            System.out.print("Enter Card Number: ");
            int cardNumber = Integer.parseInt(reader.readLine());
            System.out.print("Enter Card Holder Name: ");
            String cardHolderName = reader.readLine();

            // Change payment method to Credit Card
            rider.changePaymentMethod(new CreditCardPayment(cardNumber, cardHolderName));
        } else if (paymentChoice.equals("2")) {
            System.out.print("Enter PayPal Email: ");
            String email = reader.readLine();
            System.out.print("Enter OTP: ");
            int otp = Integer.parseInt(reader.readLine());

            // Change payment method to PayPal
            rider.changePaymentMethod(new PayPalPayment(email, otp));
        } else if (paymentChoice.equals("3")) {
            System.out.print("Enter Wallet ID: ");
            String walletId = reader.readLine();
            System.out.print("Enter OTP: ");
            int otp = Integer.parseInt(reader.readLine());

            // Change payment method to Digital Wallet
            rider.changePaymentMethod(new DigitalWalletPayment(walletId, otp));
        } else {
            System.out.println("Invalid payment method selected.");
        }
    }
}
