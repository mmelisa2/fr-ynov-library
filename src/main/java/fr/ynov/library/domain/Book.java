package fr.ynov.library.domain;

public class Book {

    private String title;
    private String author;
    private Genre genre;
    private int pageNumber;
    private Language language;
    private String publisher;
    private int publishedYear;

    public Book(String title, String author, Genre genre, int pageNumber, Language language, String publisher, int publishedYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pageNumber = pageNumber;
        this.language = language;
        this.publisher = publisher;
        this.publishedYear = publishedYear;

    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre){
        this.genre = genre;
    }
    public int getPages(){
        return pageNumber;
    }
    public void setPages(int pages){
        this.pageNumber = pages;
    }
    public Language getLanguage() {
        return language;
    }
    public void setLanguage(Language language) {
        this.language = language;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public int getPublishedYear() {
        return publishedYear;
    }
    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Page Number: " + pageNumber +
                ", Language: " + language + ", Publisher: " + publisher + ", Published Year: " + publishedYear;
    }
}
