package exercise_7_CsvParser;

import java.util.ArrayList;
import java.util.Date;

public class UserManagment {

    private ArrayList<User> users;

    public UserManagment() {
        this.users = new ArrayList<>();
    }

    public void addUser(String name, int age, String phone, String email, Date date) {
        User user = new User(name, age, phone, email, date);
        this.users.add(user);
    }

    public void getUsers() {
        users.stream().forEach(
                user -> System.out.println(
                        "\n\n===========================" +
                        "\nNome: " + user.getName() +
                        "\nIdade: " + user.getAge() +
                        "\nTelefone: " + user.getPhone() +
                        "\nEmail: " + user.getEmail() +
                        "\nData registro: " + user.getDate() +
                        "\n==========================="
                )
        );
    }
}
