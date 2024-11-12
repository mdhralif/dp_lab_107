public class FacebookNotification implements Notification
{
    @Override
    public void markAsRead() {
        System.out.println("Facebook notification marked as read");
    }

    @Override
    public void markAsUnread() {
        System.out.println("Facebook notification marked as unread");
    }

    @Override
    public void delete() {
        System.out.println("Facebook notification deleted");
    }
}
