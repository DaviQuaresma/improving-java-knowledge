package exercise_12_PaymentSystem;

public class Product {
    private String name;
    private int stock;
    private double price;
    private double discount;

    public Product(double price, int stock, String name) {
        this.price = price;
        this.stock = stock;
        this.name = name;
        this.discount = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public double getFinalPrice() {
        double originalPrice = price;
        double discount = originalPrice * (this.discount / 100);
        return originalPrice - discount;
    }

}
