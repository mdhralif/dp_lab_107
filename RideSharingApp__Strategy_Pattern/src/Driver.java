public class Driver {
    private String name;
    private String vehicleType;
    private double rating;
    private boolean available;

    public Driver(String name, String vehicleType, double rating) {
        this.name = name;
        this.vehicleType = vehicleType;
        this.rating = rating;
        this.available = true;
    }

    public void acceptRide(Rider rider, Trip trip) {
        System.out.println(name + " has accepted the ride request from " + rider.getName());
        available = false;
    }

    public void startTrip() {
        System.out.println(name + " has started the trip.");
    }

    public void completeTrip() {
        System.out.println(name + " has completed the trip.");
        available = true;
    }
}