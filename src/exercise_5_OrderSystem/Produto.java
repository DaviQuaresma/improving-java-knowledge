package exercise_5_OrderSystem;

import java.math.BigDecimal;
import java.util.Random;

public class Produto {
    private int codigo;
    private String name;
    private BigDecimal preco;
    private int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Produto(String name, BigDecimal preco, int quantidade) {
        Random random = new Random();

        this.name = name;
        this.preco = preco;
        this.quantidade = quantidade;
        this.codigo = random.nextInt(10000);
    }
}
