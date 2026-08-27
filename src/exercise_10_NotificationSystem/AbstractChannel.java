package exercise_10_NotificationSystem;

public abstract class AbstractChannel implements NotificationStrategy{

    public AbstractChannel() {
    }

    @Override
    public void receiveNotification(String message) {
        System.out.println("received notification");
        System.out.println("Message received: " + message);
    }
}
