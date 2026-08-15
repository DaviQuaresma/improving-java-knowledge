package exercise_7_CsvParser;

import java.util.Date;

public class User {
    private String name;
    private final int age;
    private final String phone;
    private final String email;
    private final Date date;

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public Date getDate() {
        return date;
    }

    public User(String name, int age, String phone, String email, Date date) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.date = date;
    }

}
