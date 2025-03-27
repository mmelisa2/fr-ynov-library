package fr.ynov.library.domain;

import java.util.List;
import java.util.ArrayList;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }
    public void addBook(String title, String author, Genre genre, int pages, Language language, String publisher, int publishedYear) {
        books.add(new Book(title, author, genre, pages, language, publisher, publishedYear));
        System.out.println("Book added to library:" + title);
    }

    public List<Book> getBooks() {
        return books;
    }
    public void displayBooks(){
        if (books.isEmpty()){
            System.out.println("No books in the library.");
        } else {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
}
