import java.util.ArrayList;
import java.util.List;

public class NotificationAggregator
{
    private final List<Notification> notifications;

    public NotificationAggregator()
    {
        notifications=new ArrayList<>();
    }

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public void markAllAsRead() {
        for (Notification notification : notifications) {
            notification.markAsRead();
        }
    }

    public void markAllAsUnread() {
        for (Notification notification : notifications) {
            notification.markAsUnread();
        }
    }

    public void deleteAllNotifications() {
        for (Notification notification : notifications) {
            notification.delete();
        }
        notifications.clear();
    }
}
