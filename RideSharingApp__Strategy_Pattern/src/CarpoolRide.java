public class CarpoolRide implements RideTypeStrategy {
    @Override
    public double calculateFare(double distance, double baseFare) {
        return (baseFare + distance * 0.5) / 2;  // Carpool fare is split
    }
}