package exercise_10_NotificationSystem;

public class Network {
    private String message;
    private NotificationStrategy channel;

    public Network(String message, NotificationStrategy channel) {
        this.message = message;
        this.channel = channel;
    }

    public void sendMessage() {
        channel.receiveNotification(message);
    }
}
