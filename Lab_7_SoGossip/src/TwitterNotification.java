public class TwitterNotification implements Notification
{
    @Override
    public void markAsRead() {
        System.out.println("Twitter notification marked as read");
    }

    @Override
    public void markAsUnread() {
        System.out.println("Twitter notification marked as unread");
    }

    @Override
    public void delete() {
        System.out.println("Twitter notification deleted");
    }
}
