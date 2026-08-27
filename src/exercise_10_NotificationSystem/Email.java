package exercise_10_NotificationSystem;

public class Email extends AbstractChannel {
    @Override
    public void receiveNotification(String message) {
        System.out.println("Email received notification");
        System.out.println("Message received: " + message);
    }
}
