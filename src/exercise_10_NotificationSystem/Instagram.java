package exercise_10_NotificationSystem;

public class Instagram extends AbstractChannel {
    @Override
    public void receiveNotification(String message) {
        System.out.println("Instagram received notification");
        System.out.println("Message received: " + message);
    }
}
