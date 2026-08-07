package exercise_3_ShoppingCart;


import java.math.BigDecimal;

public interface CarrinhoInterface {
    void addProduct(Produto produto, int quantidade);
    void removeProduct(int produtoId);
    void updateQuantity(int produtoId, int quantidade);
    BigDecimal calculateTotal();
}
