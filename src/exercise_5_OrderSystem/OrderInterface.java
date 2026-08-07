package exercise_5_OrderSystem;

import java.math.BigDecimal;

public interface OrderInterface {
    void addProduct(String name, String preco, int quantidade);
    void removeProduct(int codigo);

    void changeStatus(Status status);

    BigDecimal totalOrder();

    void getOrder();
}
