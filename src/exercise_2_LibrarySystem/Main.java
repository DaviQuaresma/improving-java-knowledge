package exercise_2_LibrarySystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2001, Calendar.JANUARY, 15);

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        Library lib = new Library();

        Scanner input = new Scanner(System.in);
        int options;
        int book_id;

        do {
            System.out.println("==============================");
            System.out.println("Sistema de emprestimo de livros");
            System.out.println("==============================\n\n");

            System.out.println("Digite uma das opções abaixo para começar...");
            System.out.println("\n1 - Adicionar um livro");
            System.out.println("\n2 - Ver livros");
            System.out.println("\n3 - Pegar livro emprestado");
            System.out.println("\n4 - Devolver livro");
            System.out.println("\n5 - Ver emprestimos");
            System.out.println("\n6 - Cadastrar um usuario");
            System.out.println("\n7 - Ver usuarios");
            System.out.println("\n0 - Sair");
            System.out.println("==============================\n\n");

            options = input.nextInt();
            input.nextLine();

            switch (options) {
                case 1:
                    System.out.println("==============================");
                    System.out.println("Adicionando livro");
                    System.out.println("==============================\n\n");

                    System.out.println("Digite o nome do livro:");
                    String name = input.nextLine();

                    System.out.println("Digite o ano de publicação do livro nesse formato (dd/mm/YYYY):");
                    String date = input.nextLine();

                    Date dataDoLivro;
                    try {
                        dataDoLivro = formatador.parse(date);
                    } catch (ParseException e) {
                        System.out.println("Formato de data inválido! Usando a data atual como padrão.");
                        dataDoLivro = new Date();
                    }

                    System.out.println("Digite o nome do autor do livro:");
                    String author = input.nextLine();

                    Book book = new Book(name, dataDoLivro, author);
                    lib.newBook(book);

                    System.out.println("\nLivro cadastrado com sucesso!\n");
                    break;
                case 2:
                    System.out.println("==============================");
                    System.out.println("Ver Todos os Livros");
                    System.out.println("==============================\n\n");

                    lib.listBooks();
                    break;
                case 3:
                    System.out.println("==============================");
                    System.out.println("Pegar livro emprestado");
                    System.out.println("==============================\n\n");

                    System.out.println("Digite o ID do livro:");
                    book_id = input.nextInt();

                    System.out.println("Digite o ID do usuario:");
                    int user_id = input.nextInt();

                    lib.borrowBook(book_id, user_id);

                    break;
                case 4:
                    System.out.println("==============================");
                    System.out.println("Devolver livro");
                    System.out.println("==============================\n\n");

                    System.out.println("Digite o ID do livro:");
                    book_id = input.nextInt();

                    lib.returnBook(book_id);

                    break;
                case 5:
                    System.out.println("==============================");
                    System.out.println("Ver emprestimos");
                    System.out.println("==============================\n\n");

                    lib.listLoans();
                    break;
                case 6:
                    System.out.println("==============================");
                    System.out.println("Cadastrar um usuario");
                    System.out.println("==============================\n\n");

                    System.out.println("Digite o nome do usuario: ");
                    name = input.nextLine();

                    User user = new User(name);
                    lib.newUser(user);

                    System.out.println("\nUsuario cadastrado com sucesso!\n");

                    break;
                case 7:
                    System.out.println("==============================");
                    System.out.println("Ver usuarios");
                    System.out.println("==============================\n\n");

                    lib.listUsers();
                    break;

                default:
                    System.out.println("Opção invalida!!");
            }
        } while (options != 0);

        input.close();
    }
}

//2. Sistema de biblioteca
//Cadastre livros e usuários e controle empréstimos.
//Use: Collections, interfaces, composição.