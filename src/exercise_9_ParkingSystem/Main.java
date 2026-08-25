package exercise_9_ParkingSystem;

public class Main {
    public static void main(String[] args) {

        Park park = new Park();

        Car car1 = new Car("March", "Nissan", 2015);
        Car car2 = new Car("Honda City", "Honda", 2011);
        Car car3 = new Car("Honda Civic", "Honda", 2014);
        Car car4 = new Car("Honda CG 160", "Honda", 2015);
        Car car5 = new Car("Yamaha Factor 150", "Yamaha", 2015);

        park.carIn(car1);
        park.carIn(car2);
        park.carIn(car3);
        park.carIn(car4);
        park.carIn(car5);

        park.getCarsInPark();

        // Simula saída após 30 minutos
        park.carOut(car1, 30);

        // Simula saída após 2 horas
        park.carOut(car2, 120);

        // Simula saída após 1 dia
        park.carOut(car3, 1440);
    }
}

//9. Sistema de estacionamento
//Controle entrada, saída e cálculo de preço.
//Use: Date/Time API, Duration, Collections.