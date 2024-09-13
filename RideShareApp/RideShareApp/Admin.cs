using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RideShareApp
{

    public class Admin 
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public double Rating { get; set; }

        public Admin()
        {

        }
        
        public void ManageDriver(Driver driver)
        {
            
            Console.WriteLine($"{Name} is managing driver {driver.Name}");
           
        }

        public void ManageRider(Rider rider)
        {
            
            Console.WriteLine($"{Name} is managing rider {rider.Name}");
        }

        public void ViewTripHistory(List<Trip> trips)
        {
            Console.WriteLine($"{Name} is viewing trip history:");
            foreach (var trip in trips)
            {
                Console.WriteLine($"Trip {trip.Id}: {trip.PickupLocation} to {trip.DropOffLocation}, Fare: {trip.Fare}");
            }
        }
    }
}
