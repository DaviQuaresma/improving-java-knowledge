package exercise_3_ShoppingCart;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Produto {
    private int id;
    private String nome;
    private BigDecimal preco;
    Set<String> categorias;

    public int getId() {
        return id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Set<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<String> categorias) {
        this.categorias = categorias;
    }

    public Produto(int id, String nome, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categorias = new HashSet<String>();
    }

    public void addCategorie(String name){
        this.categorias.add(name);
    }

    public void removeCategorie(String name){
        this.categorias.remove(name);
    }
}
