public class LinkedInNotification implements Notification
{
    @Override
    public void markAsRead() {
        System.out.println("LinkedIn notification marked as read");
    }

    @Override
    public void markAsUnread() {
        System.out.println("LinkedIn notification marked as unread");
    }

    @Override
    public void delete() {
        System.out.println("LinkedIn notification deleted");
    }

}
