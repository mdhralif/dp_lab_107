public class SocialMediaAggregatorApp
{
    public static void main(String[] args) {
        NotificationAggregator aggregator = new NotificationAggregator();

        Notification twitterNotification = new TwitterNotification();
        Notification facebookNotification = new FacebookNotification();
        Notification linkedInNotification = new LinkedInNotification();

        aggregator.addNotification(twitterNotification);
        aggregator.addNotification(facebookNotification);
        aggregator.addNotification(linkedInNotification);

        System.out.println("Marking all notifications as read:");
        aggregator.markAllAsRead();

        System.out.println("\nMarking all notifications as unread:");
        aggregator.markAllAsUnread();

        System.out.println("\nDeleting all notifications:");
        aggregator.deleteAllNotifications();
    }
}
