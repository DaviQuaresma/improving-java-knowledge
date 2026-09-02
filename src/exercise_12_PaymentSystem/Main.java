package exercise_12_PaymentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AbstractMarketplace ebay = new AbstractMarketplace("Ebay", new EbayDiscount());
        AbstractMarketplace amazon = new AbstractMarketplace("Amazon", new AmazonDiscount());

        amazon.addProduct("Alexa", 10, 329.90);
        amazon.addProduct("Smart TV 50'", 30, 3300.00);
        amazon.addProduct("Liquidificador", 80, 149.90);
        amazon.addProduct("Pilhas recarregaveis", 240, 9.90);

        ebay.addProduct("Mega Blocks Halo", 70, 319.90);
        ebay.addProduct("Xbox 360", 20, 589.90);
        ebay.addProduct("PlayStation 4", 15, 1290.20);
        ebay.addProduct("Camisa personalizada", 124, 19.90);

        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("\n==============================");
            System.out.println("       SISTEMA DE DESCONTOS");
            System.out.println("==============================");
            System.out.println("1 - Ver produtos da Amazon");
            System.out.println("2 - Ver produtos da Ebay");
            System.out.println("3 - Aplicar desconto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("\n=== PRODUTOS AMAZON ===");
                    amazon.getProductsList();
                    break;

                case 2:
                    System.out.println("\n=== PRODUTOS EBAY ===");
                    ebay.getProductsList();
                    break;

                case 3:

                    System.out.println("\nQual marketplace?");
                    System.out.println("1 - Amazon");
                    System.out.println("2 - Ebay");
                    System.out.print("Escolha: ");

                    int marketplace = scanner.nextInt();

                    AbstractMarketplace escolhido;

                    if (marketplace == 1) {
                        escolhido = amazon;
                    } else if (marketplace == 2) {
                        escolhido = ebay;
                    } else {
                        System.out.println("Marketplace inválido!");
                        break;
                    }

                    System.out.println("\n=== PRODUTOS DISPONÍVEIS ===");
                    escolhido.getProductsList();

                    System.out.print("\nDigite o ID do produto: ");
                    int id = scanner.nextInt();

                    escolhido.applyDiscount(id);

                    System.out.println("\n>> Desconto aplicado!");

                    System.out.println("\n=== PRODUTOS ATUALIZADOS ===");
                    escolhido.getProductsList();

                    break;

                case 0:
                    System.out.println("\nPrograma encerrado. Até mais!");
                    break;

                default:
                    System.out.println("\n>> Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}

//12. Sistema de descontos
//
//Aplique diferentes regras de desconto.
//Use: Strategy, composição.