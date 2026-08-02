package LibrarySystem_exercise_2;

public interface LibraryInterface {

    void newUser(User user);
    void newBook(Book book);

    void borrowBook(int bookId, int userId);
    void returnBook(int bookId);

    void listBooks();
    void listUsers();
    void listLoans();

}
