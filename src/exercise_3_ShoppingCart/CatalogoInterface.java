package exercise_3_ShoppingCart;

import java.util.List;

public interface CatalogoInterface {
    void addProduct(String preco, String nome);
    void removeProduct(int id);
    Produto getProductId(int id);
    List<Produto> getProducts();
}
