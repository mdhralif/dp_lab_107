public abstract class User {
    public int id;
    public String name;
    public String location;
    public double rating;

    public User(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rating = 5.0; // Default rating for a new user
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double getRating() {
        return rating;
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayInfo();
}
