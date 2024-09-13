using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RideShareApp
{
    public interface INotificationService
    {
        void SendNotification(NotificationType type, string message, User user);
    }
}
