package fr.ynov.library.domain;

public class Book {
//Initializing necessary variables and components of a potential book that could be added to a library
    private final String title;
    private final String author;
    private final Genre genre;
    private final int pageNumber;
    private final Language language;
    private final String publisher;
    private final int publishedYear;
    private ReadingStatus readingStatus;

    public Book(String title, String author, Genre genre, int pageNumber, Language language, String publisher, int publishedYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pageNumber = pageNumber;
        this.language = language;
        this.publisher = publisher;
        this.publishedYear = publishedYear;
        this.readingStatus = ReadingStatus.WANT_TO_READ;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public Genre getGenre() {
        return genre;
    }
    public int getPages(){
        return pageNumber;
    }
    public Language getLanguage() {
        return language;
    }
    public String getPublisher() {
        return publisher;
    }
    public int getPublishedYear() {
        return publishedYear;
    }
    public ReadingStatus getReadingStatus() {
        return readingStatus;
    }
    public void setReadingStatus(ReadingStatus readingStatus) {
        this.readingStatus = readingStatus;
    }

    // Displaying text for the users to understand the information relating to their added book.
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Page Number: " + pageNumber + ", Language: "
                + language + ", Publisher: " + publisher + ", Published Year: " + publishedYear + ", Reading Status: " + readingStatus;
    }
}
