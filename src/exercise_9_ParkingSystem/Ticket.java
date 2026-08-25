package exercise_9_ParkingSystem;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Duration period;
    private float price;
    private static final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Ticket() {
        this.checkIn = LocalDateTime.now();
        this.checkOut = null;
        this.period = null;
        this.price = 0.0f;
    }

    public String getCheckInFormatado() {
        if (this.checkIn == null) {
            return "Não realizado";
        }
        return this.checkIn.format(FORMATADOR);
    }

    public String getCheckOutFormatado() {
        if (this.checkOut == null) {
            return "Em aberto";
        }
        return this.checkOut.format(FORMATADOR);
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public float getPrice() {

        if (this.period == null) {
            return price;
        }

        float valuePerMinut = 0.45f;
        float minuts = this.period.toSeconds() / 60.0f;
        return valuePerMinut * minuts;
    }

    public Duration getPeriod() {
        return period;
    }

    public void setPeriod(Duration period) {
        this.period = period;
    }

}
