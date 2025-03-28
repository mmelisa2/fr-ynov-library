package fr.ynov.library.gui.buttons;

import fr.ynov.library.domain.Book;
import fr.ynov.library.domain.Genre;
import fr.ynov.library.domain.Language;
import fr.ynov.library.factory.BookFactory;
import fr.ynov.library.gui.panels.InputPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookButton extends JButton {
    private final DefaultListModel<Book> bookListModel;
    private final InputPanel inputPanel;
    private final JFrame parentFrame;

    public AddBookButton(DefaultListModel<Book> bookListModel, InputPanel inputPanel, JFrame parentFrame) {
        super("Add Book");
        this.bookListModel = bookListModel;
        this.inputPanel = inputPanel;
        this.parentFrame = parentFrame;

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });
    }

    private void addBook() {
        String title = inputPanel.getTitle();
        String author = inputPanel.getAuthor();
        Genre genre = inputPanel.getGenre();
        String pageNumber = inputPanel.getPageNumber();
        Language language = inputPanel.getLanguage();
        String publisher = inputPanel.getPublisher();
        String publishedYear = inputPanel.getPublishedYear();

        if (title.isEmpty() || author.isEmpty() || genre == null || pageNumber.isEmpty()
                || language == null || publisher.isEmpty() || publishedYear.isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame, "Please fill all the required fields!");
            return;
        }

        try {
            int pages = Integer.parseInt(pageNumber);
            int year = Integer.parseInt(publishedYear);
            Book newBook = BookFactory.createBook(title, author, genre, pages, language, publisher, year);
            bookListModel.addElement(newBook);
            inputPanel.clearFields();
        } catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(parentFrame, "Invalid input! The [Page Number] and [Published Year] values have to be numbers.");
        }
    }
}