using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RideShareApp
{
    public class Rider : User
    {
        public string Location { get; set; }
        public void RequestRide(RideType rideType, string pickup, string dropOff)
        {
            Console.WriteLine($"{Name} requested a {rideType} ride from {pickup} to {dropOff}");
        }

        public void RateDriver(Driver driver, double rating)
        {
            driver.Rating = (driver.Rating + rating) / 2;
            Console.WriteLine($"{Name} rated driver {driver.Name} with {rating} stars");
        }

        public void MakePayment(IPaymentMethod paymentMethod, double fare)
        {
            paymentMethod.ProcessPayment(fare, this);
        }
       
    }
}
