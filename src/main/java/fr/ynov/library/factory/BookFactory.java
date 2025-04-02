package fr.ynov.library.factory;

import fr.ynov.library.domain.Book;
import fr.ynov.library.domain.Genre;
import fr.ynov.library.domain.Language;
import fr.ynov.library.domain.ReadingStatus;

//Creating the books with the necessary attributes.
public class BookFactory {
    public static Book createBook(String title, String author, Genre genre, int pages, Language language, String publisher, int publishedYear, ReadingStatus status) {
        Book book = new Book(title, author, genre, pages, language, publisher, publishedYear);
        book.setReadingStatus(status);
        return book;
    }
}
