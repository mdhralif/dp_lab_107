using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RideShareApp
{
    public class Trip
    {
        public int Id { get; set; }
        public string PickupLocation { get; set; }
        public string DropOffLocation { get; set; }
        public RideType RideType { get; set; }
        public TripStatus Status { get; set; }
        public double Fare { get; set; }
        public Rider Rider { get; set; }
        public Driver Driver { get; set; }

        public Trip(string pickup, string dropOff, RideType rideType, double fare, Rider rider)
        {
            PickupLocation = pickup;
            DropOffLocation = dropOff;
            RideType = rideType;
            Fare = fare;
            Rider = rider;
            Status = TripStatus.Requested;
            
        }

        public void AssignDriver(Driver driver)
        {
            Driver = driver;
            driver.AcceptRide(this);
        }

        public void CalculateFare()
        {
            Fare = 20.0;
            Console.WriteLine($"Fare calculated: {Fare}");
        }
    }
}
