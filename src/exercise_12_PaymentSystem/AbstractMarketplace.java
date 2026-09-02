package exercise_12_PaymentSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AbstractMarketplace {
    private String name;
    private Map<Integer, Product> products;
    private DiscountStrategy discountStrategy;
    Random rand = new Random();

    public AbstractMarketplace(String name, DiscountStrategy discountStrategy) {
        this.name = name;
        this.products = new HashMap<>();
        this.discountStrategy = discountStrategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addProduct(String name, int stock, double price) {
        Product product = new Product(price, stock, name);
        Integer productId = rand.nextInt(10000);
        this.products.put(productId, product);
    }

    public void removeProduct(int id) {
        this.products.remove(id);
    }

    public void getProductsList() {
        System.out.println("\n\n==================================");
        System.out.println("PRODUTOS DA LOJA: " + this.name);
        System.out.println("==================================");

        products.entrySet().stream().forEach(entry -> {
            System.out.println("ID do produto: " + (entry.getKey()));
            System.out.println("Nome do produto: " + entry.getValue().getName());
            System.out.println("Preço do produto: R$" + entry.getValue().getPrice());
            System.out.println("Estoque do produto: " + entry.getValue().getStock());
            System.out.println("Desconto do produto: " + entry.getValue().getDiscount() + "%");
            System.out.println("Preço com desconto: R$" + entry.getValue().getFinalPrice());
            System.out.println("----------------------------------");
        });
    }

    public void applyDiscount(int id) {
        discountStrategy.applyDiscount(id, products);
    }
}
