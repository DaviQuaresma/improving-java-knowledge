package exercise_3_ShoppingCart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Catalogo implements CatalogoInterface{
    List<Produto> produtos;
    private int id = 0;

    public Catalogo() {
        this.produtos = new ArrayList<>();
    }

    @Override
    public void addProduct(String preco, String nome) {
        BigDecimal value = new BigDecimal(preco);
        Produto newProduct = new Produto(id, nome, value);
        id += 1;

        this.produtos.add(newProduct);
    }

    @Override
    public void removeProduct(int id) {
        this.produtos.remove(id);
    }

    @Override
    public Produto getProductId(int id) {
        return this.produtos.get(id);
    }

    @Override
    public List<Produto> getProducts() {
        return this.produtos;
    }
}
