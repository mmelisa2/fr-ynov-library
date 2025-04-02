package fr.ynov.library.gui.buttons;

import fr.ynov.library.domain.Book;
import fr.ynov.library.domain.Genre;
import fr.ynov.library.domain.Language;
import fr.ynov.library.gui.panels.InputPanel;
import fr.ynov.library.domain.ReadingStatus;

import javax.swing.*;

public class AddBookButton extends JButton {
    private final DefaultListModel<Book> bookListModel;
    private final InputPanel inputPanel;
    private final JFrame parentFrame;

    public AddBookButton(DefaultListModel<Book> bookListModel, InputPanel inputPanel, JFrame parentFrame) {
        super("Add Book");
        this.bookListModel = bookListModel;
        this.inputPanel = inputPanel;
        this.parentFrame = parentFrame;

        addActionListener(e -> addBook());
    }

    //Getting necessary information for a book to be added to the library.
    private void addBook() {
        String title = inputPanel.getTitle();
        String author = inputPanel.getAuthor();
        Genre genre = inputPanel.getGenre();
        String pageNumber = inputPanel.getPageNumber();
        Language language = inputPanel.getLanguage();
        String publisher = inputPanel.getPublisher();
        String publishedYear = inputPanel.getPublishedYear();

        //Error message users get if either one of the required fields are empty.
        if (title.isEmpty() || author.isEmpty() || genre == null || pageNumber.isEmpty()
                || language == null || publisher.isEmpty() || publishedYear.isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame, "Please fill all the required fields!");
            return;
        }

        try {
            int pages = Integer.parseInt(pageNumber);
            int year = Integer.parseInt(publishedYear);
            Book newBook = new Book(title, author, genre, pages, language, publisher, year);
            newBook.setReadingStatus(ReadingStatus.WANT_TO_READ);
            bookListModel.addElement(newBook);
            //Clearing input fields after adding a new book to the library.
            inputPanel.clearFields();
        //Notification messages
            JOptionPane.showMessageDialog(parentFrame, "Book added: " + title + " (Reading Status: Want to Read)");
        } catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(parentFrame, "Invalid input! The [Page Number] and [Published Year] values have to be numbers.");
        }
    }
}