using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RideShareApp
{
    public class PayPalPayment : IPaymentMethod
    {
        public void ProcessPayment(double amount, Rider rider)
        {
            Console.WriteLine($"Processing PayPal payment of {amount} for {rider.Name}");
        }
       
    }
}
