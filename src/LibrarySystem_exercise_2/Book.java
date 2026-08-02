package LibrarySystem_exercise_2;

import java.util.Date;
import java.util.Random;

public class Book {
    private final String name;
    private final Date publishDate;
    private final String author;
    private final int book_id;
    private boolean available;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getBook_id() {
        return book_id;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public Book(String name, Date publishDate, String author) {
        Random rand = new Random();

        this.name = name;
        this.publishDate = publishDate;
        this.author = author;
        this.available = true;
        this.book_id = rand.nextInt(1000);
    }
}
