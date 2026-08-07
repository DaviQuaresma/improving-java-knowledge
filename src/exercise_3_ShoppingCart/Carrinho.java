package exercise_3_ShoppingCart;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Carrinho implements CarrinhoInterface {

    Map<Integer, ItemCarrinho> itens;

    public Carrinho() {
        this.itens = new HashMap<>();
    }

    @Override
    public void addProduct(Produto produto, int quantidade) {
        ItemCarrinho item = new ItemCarrinho(produto, quantidade);
        this.itens.put(produto.getId(), item);
    }

    @Override
    public void removeProduct(int produtoId) {
        this.itens.remove(produtoId);
    }

    @Override
    public void updateQuantity(int produtoId, int quantidade) {
        ItemCarrinho item = this.itens.get(produtoId);
        item.setQuantidade(item.getQuantidade() + quantidade);
    }

    @Override
    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (ItemCarrinho item : this.itens.values()) {

            BigDecimal subtotal = item.getProduto()
                    .getPreco()
                    .multiply(BigDecimal.valueOf(item.getQuantidade()));

            total = total.add(subtotal);
        }

        return total;
    }
}
