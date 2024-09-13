using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RideShareApp
{
    public interface IPaymentMethod
    {
        void ProcessPayment(double amount, Rider rider);

    }
}
