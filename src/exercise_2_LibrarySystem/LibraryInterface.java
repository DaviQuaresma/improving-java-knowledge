package exercise_2_LibrarySystem;

public interface LibraryInterface {

    void newUser(User user);
    void newBook(Book book);

    void borrowBook(int bookId, int userId);
    void returnBook(int bookId);

    void listBooks();
    void listUsers();
    void listLoans();

}
