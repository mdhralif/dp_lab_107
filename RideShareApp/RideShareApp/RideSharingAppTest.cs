using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RideShareApp
{
    public class RideSharingAppTest
    {
        public static void RunTests()
        {
            
            TestRequestAndCompleteTrip();

            TestPaymentProcessing();

            
            TestRatingSystem();

          
            TestAdminOperations();
        }

        public static void TestRequestAndCompleteTrip()
        {
            Console.WriteLine("\nTest 1");

            
            Rider rider = new Rider { Id = 1, Name = "X", Location = "Point A", Rating = 4.5 };
            Driver driver = new Driver { Id = 2, Name = "Y", VehicleType = "Sedan", Location = "Point B", Rating = 4.8 };

            
            rider.RequestRide(RideType.LuxuryRide, "Point A", "Point B");

            
            Trip trip = new Trip("Point A", "Point B", RideType.LuxuryRide, 0, rider);

            
            trip.AssignDriver(driver);
            trip.CalculateFare();

            driver.StartTrip(trip);
            driver.CompleteTrip(trip);
        }

        public static void TestPaymentProcessing()
        {
            Console.WriteLine("\nTest 2");

           
            Rider rider = new Rider { Id = 1, Name = "x", Rating = 4.5 };
            Trip trip = new Trip("Point A", "Point B", RideType.LuxuryRide, 20.0, rider);

       
            IPaymentMethod paymentMethod = new CreditCardPayment();
            rider.MakePayment(paymentMethod, trip.Fare);
        }

        public static void TestRatingSystem()
        {
            Console.WriteLine("\nTest 3");

       
            Rider rider = new Rider { Id = 1, Name = "x", Rating = 4.5 };
            Driver driver = new Driver { Id = 2, Name = "y", Rating = 4.8 };

            rider.RateDriver(driver, 5.0);


            driver.RateRider(rider, 4.5);
        }

        public static void TestAdminOperations()
        {
            Console.WriteLine("\nTest 4: Admin Operations");

          
            Admin admin = new Admin { Id = 3, Name = "Admin" };

            
            Rider rider = new Rider { Id = 1, Name = "X", Rating = 4.5 };
            Driver driver = new Driver { Id = 2, Name = "Y", Rating = 4.8 };

           
            admin.ManageDriver(driver);
            admin.ManageRider(rider);

            List<Trip> tripHistory = new List<Trip>
        {
            new Trip("Point A", "Point B", RideType.LuxuryRide, 20.0, rider)
        };
            admin.ViewTripHistory(tripHistory);
        }
    }
}
