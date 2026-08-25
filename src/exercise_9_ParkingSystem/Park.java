package exercise_9_ParkingSystem;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.time.Duration;

public class Park {

    Map<Ticket, Car> parkMap;

    public Park() {
        this.parkMap = new HashMap<Ticket, Car>();
    }

    public void carIn(Car car){
        Ticket newTicket = new Ticket();
        parkMap.put(newTicket, car);

        System.out.println("\n=========================");
        System.out.println("Entrada de novo carro");
        System.out.println("-------------------------");
        System.out.println("Info do carro:");
        System.out.println("Nome: " + car.getName());
        System.out.println("Marca: " + car.getBrand());
        System.out.println("Ano: " + car.getYear());
        System.out.println("-------------------------");
        System.out.println("Info do ticket:");
        System.out.println("Valor atual: " + newTicket.getPrice());
        System.out.println("Horario de entrada: " + newTicket.getCheckInFormatado());
        System.out.println("Horario de saida: " + newTicket.getCheckOutFormatado());
        System.out.println("=========================");
    }

    public void carOut(Car car, long minutesPassed) {
        Ticket usedTicket = parkMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(car))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        if (usedTicket == null) {
            System.out.println("Carro não encontrado no estacionamento!");
            return;
        }

        // Simula que o carro saiu X minutos depois da entrada
        usedTicket.setCheckOut(
                usedTicket.getCheckIn().plusMinutes(minutesPassed)
        );

        usedTicket.setPeriod(
                Duration.between(
                        usedTicket.getCheckIn(),
                        usedTicket.getCheckOut()
                )
        );

        System.out.println("========================");
        System.out.println("Valor a pagar: " + usedTicket.getPrice());
        System.out.println("Horario de entrada: " + usedTicket.getCheckInFormatado());
        System.out.println("Horario de saida: " + usedTicket.getCheckOutFormatado());
        System.out.println("Periodo de estadia: " + usedTicket.getPeriod());
        System.out.println("========================");

        parkMap.entrySet().removeIf(entry -> entry.getValue().equals(car));
    }

    public void getCarsInPark(){
        parkMap.entrySet().stream().forEach(entry -> {
            System.out.println("\n===============================");
            System.out.println("Ticket: " + entry.getKey().getPrice());
            System.out.println("Name: " + entry.getValue().getName());
            System.out.println("Marca: " + entry.getValue().getBrand());
            System.out.println("Ano: " + entry.getValue().getYear());
            System.out.println("===============================");
        });
    }
}
