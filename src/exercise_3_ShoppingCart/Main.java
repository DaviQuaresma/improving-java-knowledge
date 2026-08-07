package exercise_3_ShoppingCart;

public class Main {
    public static void main(String[] args){
        Catalogo catalogo = new Catalogo();
        catalogo.addProduct("450", "Xbox 360");
        catalogo.addProduct("2550", "Notebook");
        catalogo.addProduct("3250", "TV 67'");

        Carrinho carrinho = new Carrinho();
        carrinho.addProduct(catalogo.getProductId(0), 5);
        carrinho.addProduct(catalogo.getProductId(2), 1);
        System.out.println("Total: R$ " + carrinho.calculateTotal());

    }
}
