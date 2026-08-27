package exercise_10_NotificationSystem;

public class Main {
    public static void main(String[] args){
        NotificationStrategy email = new Email();
        Network net = new Network("Você tem uma nova mensagem de 'Davi'", email);

        net.sendMessage();

    }
}

//10. Sistema de notificações
//Envie notificações por diferentes canais.
//Use: interfaces, polimorfismo, Strategy.