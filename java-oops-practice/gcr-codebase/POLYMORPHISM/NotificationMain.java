public class NotificationMain {
    public static void main(String[] args) {
        Notification[] notifications = {
            new EmailNotification("Alice", "Your order has been shipped!"),
            new SMSNotification("Bob", "Your OTP is 123456"),
            new PushNotification("Charlie", "New friend request"),
            new EmailNotification("Diana", "Meeting at 3 PM tomorrow"),
            new SMSNotification("Eve", "Payment received successfully")
        };

        for (Notification n : notifications) {
            n.sendNotification();
        }
    }
}
