package exercise_8_ContactsList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ContactBook contactBook = new ContactBook();
        contactBook.addContact("Davi", "quaresma@gmail.com", "31 9 92850463");
        contactBook.addContact("Jorge", "Jorge@gmail.com", "31 9 92827863");
        contactBook.addContact("Pedro", "Pedro@gmail.com", "31 9 92850252");
        contactBook.addContact("Alex", "Alex@gmail.com", "31 9 91940463");

        contactBook.getContacts();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nDigite o ID do contato (0 para sair): ");
            int id = scanner.nextInt();

            if (id == 0) {
                break;
            }

            contactBook.getContactById(id);
        }

        scanner.close();
    }
}