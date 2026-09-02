package exercise_12_PaymentSystem;

import java.util.Map;

public class EbayDiscount implements DiscountStrategy {

    @Override
    public void applyDiscount(int id, Map<Integer, Product> products) {
        Product product = products.get(id);

        if (product.getStock() >= 30) {
            product.setDiscount(45);
        } else {
            product.setDiscount(20);
        }
    }
}