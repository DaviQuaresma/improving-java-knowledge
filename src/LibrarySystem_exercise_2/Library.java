package LibrarySystem_exercise_2;

import java.util.List;
import java.util.ArrayList;

public class Library implements LibraryInterface {

    List<Book> booksList = new ArrayList<>();
    List<User> usersList = new ArrayList<>();
    List<Loan> loansList = new ArrayList<>();

    public Library() {
    }

    @Override
    public void newUser(User user) {
        usersList.add(user);
    }

    @Override
    public void newBook(Book book) {
        booksList.add(book);
    }

    @Override
    public void borrowBook(int bookId, int userId) {

        Book selectedBook = null;
        User selectedUser = null;

        for (Book book : booksList) {
            if(book.getBook_id() == bookId){
                selectedBook = book;
            }
        }

        for (User user : usersList) {
            if(user.getId() == userId){
                selectedUser = user;
            }
        }

        if (selectedBook.isAvailable()){
            Loan loan = new Loan(selectedBook, selectedUser);
            loansList.add(loan);
            selectedBook.setAvailable(false);
        } else {
            System.out.println("Book is not available");
        }

    }

    @Override
    public void returnBook(int bookId) {
        Book selectedBook = null;
        Loan selectedLoan = null;

        for (Loan loan : loansList) {
            if(loan.getBook().getBook_id() == bookId){
                selectedBook = loan.getBook();
                selectedLoan = loan;
            }
        }

        if (!selectedBook.isAvailable()){
            loansList.remove(selectedLoan);
            selectedBook.setAvailable(true);
        } else {
            System.out.println("This book isn't borrowed");
        }

    }

    @Override
    public void listBooks() {
        for (Book book : booksList) {
            System.out.println("Nome do livro: " + book.getName());
            System.out.println("Nome do autor: " + book.getAuthor());
            System.out.println("Data de publicação: " + book.getPublishDate());
            System.out.println("ID do livro: " + book.getBook_id());
        }
    }

    @Override
    public void listUsers() {
        for(User user : usersList) {
            System.out.println("Nome do usuario: " + user.getName());
            System.out.println("ID do usuario: " + user.getId());
        }
    }

    @Override
    public void listLoans() {
        for(Loan loan : loansList) {
            System.out.println("-----------------------------");
            System.out.println("ID do Livro: " + loan.getBook().getBook_id());
            System.out.println("Nome do Livro: " + loan.getBook().getName());
            System.out.println("-----------------------------");
            System.out.println("ID do User: " + loan.getUser().getId());
            System.out.println("Nome do User: " + loan.getUser().getName());
            System.out.println("-----------------------------");
        }
    }
}
