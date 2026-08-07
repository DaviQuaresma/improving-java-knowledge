package exercise_2_LibrarySystem;

import java.util.Date;

public class Loan {

    private final Book book;
    private final User user;
    private final Date loanDate;

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public Loan(Book book, User user) {
        this.book = book;
        this.user = user;
        this.loanDate = new Date();
    }
}
