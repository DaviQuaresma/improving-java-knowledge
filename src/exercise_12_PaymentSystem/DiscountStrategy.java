package exercise_12_PaymentSystem;

import java.util.Map;

public interface DiscountStrategy {
    void applyDiscount(int id, Map<Integer, Product> products);
}
