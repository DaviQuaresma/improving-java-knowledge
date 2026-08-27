package exercise_10_NotificationSystem;

public class Telefone extends AbstractChannel {
    @Override
    public void receiveNotification(String message) {
        System.out.println("Telefone received notification");
        System.out.println("Message received: " + message);
    }
}
