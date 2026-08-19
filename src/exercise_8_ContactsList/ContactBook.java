package exercise_8_ContactsList;

import exercise_1_BankAccount.Conta;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ContactBook {

    Map<Integer, Contact> contacts;
    Random rand = new Random();

    public ContactBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String email, String phone) {
        Contact contact = new Contact(name, email, phone);
        Integer id = rand.nextInt(10000);

        contacts.put(id, contact);
    }

    public void getContactById(Integer id) {
        Optional<Contact> optionalContact = findById(id);

        optionalContact.ifPresent(contact -> {
            System.out.println("\n===============================");
            System.out.println("Name: " + contact.getName());
            System.out.println("Email: " + contact.getEmail());
            System.out.println("Phone: " + contact.getPhone());
            System.out.println("===============================");
        });

        if(optionalContact.isEmpty()) {
            System.out.println("Contact not found");
        }
    }

    private Optional<Contact> findById(Integer id) {
        return Optional.ofNullable(contacts.get(id));
    }

    public void getContacts(){
        contacts.entrySet().stream().forEach(entry -> {
            System.out.println("\n===============================");
            System.out.println("ID: " + entry.getKey());
            System.out.println("Name: " + entry.getValue().getName());
            System.out.println("Email: " + entry.getValue().getEmail());
            System.out.println("Phone: " + entry.getValue().getPhone());
            System.out.println("===============================");
        });
    }
}
