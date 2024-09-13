using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RideShareApp
{
    public class Driver : User
    {
        public string VehicleType { get; set; }
        public string Location { get; set; }
        public bool IsAvailable { get; set; } = true;

        public void AcceptRide(Trip trip)
        {
            IsAvailable = false;
            trip.Status = TripStatus.Accepted;
            Console.WriteLine($"{Name} accepted the ride.");
        }

        public void StartTrip(Trip trip)
        {
            trip.Status = TripStatus.InProgress;
            Console.WriteLine($"{Name} started the trip.");
        }

        public void CompleteTrip(Trip trip)
        {
            IsAvailable = true;
            trip.Status = TripStatus.Completed;
            Console.WriteLine($"{Name} completed the trip.");
        }

        public void RateRider(Rider rider, double rating)
        {
            rider.Rating = (rider.Rating + rating) / 2;
            Console.WriteLine($"{Name} rated rider {rider.Name} with {rating} stars");
        }
    }
}
