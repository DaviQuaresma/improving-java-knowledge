package exercise_12_PaymentSystem;

import java.util.Map;

public class AmazonDiscount implements DiscountStrategy {

    @Override
    public void applyDiscount(int id,  Map<Integer, Product> products) {
        Product product = products.get(id);

        if(product.getStock() >= 50){
            product.setDiscount(25);
        } else {
            product.setDiscount(10);
        }
    }
}
