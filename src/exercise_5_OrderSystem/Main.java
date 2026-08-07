package exercise_5_OrderSystem;


public class Main {
    public static void main(String[] args) {

        Order order = new Order();

        order.addProduct("Celular", "2500", 2);
        order.addProduct("Notebook", "3500", 1);
        order.addProduct("PS5", "5500", 1);
        order.addProduct("Monitor", "500", 2);

        System.out.println(order.totalOrder());
    }
}
