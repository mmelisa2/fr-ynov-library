package fr.ynov.library.factory;

import fr.ynov.library.domain.Book;
import fr.ynov.library.domain.Genre;
import fr.ynov.library.domain.Language;

public class BookFactory {
    public static Book createBook(String title, String author, Genre genre, int pages, Language language, String publisher, int publishedYear) {
        return new Book(title, author, genre, pages, language, publisher, publishedYear);
    }
}
