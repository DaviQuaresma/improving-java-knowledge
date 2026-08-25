package exercise_9_ParkingSystem;

import java.util.Objects;

public class Car {
    private  String name;
    private  String brand;
    private int year;

    public Car(String name, String brand, int year) {
        this.name = name;
        this.brand = brand;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(name, car.name) && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, brand, year);
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

}
