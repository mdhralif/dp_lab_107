public class LuxuryRide implements RideTypeStrategy {
    @Override
    public double calculateFare(double distance, double baseFare) {
        return baseFare + distance * 2.0;  // Higher fare for luxury rides
    }
}