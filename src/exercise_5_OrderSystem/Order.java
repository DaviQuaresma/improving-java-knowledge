package exercise_5_OrderSystem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Order implements OrderInterface{

    private ArrayList<Produto> produtos;
    private Status status;

    public Order(){
        this.produtos = new ArrayList<>();
        this.status = Status.PENDING;
    }

    @Override
    public void addProduct(String name, String preco, int quantidade) {
        BigDecimal value = new BigDecimal(preco);
        Produto produto = new Produto(name, value, quantidade);
        produtos.add(produto);
    }

    @Override
    public void removeProduct(int codigo) {
        produtos.remove(codigo);
    }

    @Override
    public void changeStatus(Status status) {
        this.status = status;
    }

    @Override
    public BigDecimal totalOrder() {
        BigDecimal total = BigDecimal.ZERO;

        for (Produto produto : produtos) {
            BigDecimal subtotal = produto
                    .getPreco()
                    .multiply(BigDecimal.valueOf(produto.getQuantidade()));

            total = total.add(subtotal);
        }

        return total;
    }

    @Override
    public void getOrder() {
        int i = 1;
        for(Produto produto : produtos) {
            System.out.println("\n==========================================");
            System.out.println("Produto " + i);
            System.out.println("==========================================");
            System.out.println("\nNome do produto: " + produto.getName());
            System.out.println("\nPreço do produto: " + produto.getPreco());
            System.out.println("\nQuantidade do produto: " + produto.getQuantidade());
            i += 1;
        }
    }
}
