package fr.ynov.library.gui;

import fr.ynov.library.domain.Book;
import fr.ynov.library.domain.Language;
import fr.ynov.library.domain.Library;
import fr.ynov.library.domain.Genre;
import fr.ynov.library.factory.BookFactory;
import fr.ynov.library.factory.LibraryFactory;

import javax.swing.*;
import java.awt.*;

public class LibraryGUI {
    private Library library;
    private JFrame frame;
    private DefaultListModel<Book> bookListModel;

    public LibraryGUI() {
        library = LibraryFactory.createLibrary();
        frame = new JFrame("Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 4));
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JComboBox<Genre> genreComboBox = new JComboBox<>(Genre.values());
        JTextField pageNumberField = new JTextField();
        JComboBox<Language> languageComboBox = new JComboBox<>(Language.values());
        JTextField publisherField = new JTextField();
        JTextField publishedYearField = new JTextField();
        JButton addBookButton = new JButton("Add Book");
        JButton removeBookButton = new JButton("Remove Book");

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Author:"));
        inputPanel.add(authorField);
        inputPanel.add(new JLabel("Genre:"));
        inputPanel.add(genreComboBox);
        inputPanel.add(new JLabel("Page Number:"));
        inputPanel.add(pageNumberField);
        inputPanel.add(new JLabel("Language:"));
        inputPanel.add(languageComboBox);
        inputPanel.add(new JLabel("Publisher:"));
        inputPanel.add(publisherField);
        inputPanel.add(new JLabel("Published Year:"));
        inputPanel.add(publishedYearField);
        inputPanel.add(addBookButton);
        inputPanel.add(removeBookButton);

        bookListModel = new DefaultListModel<>();
        JList<Book> bookList = new JList<>(bookListModel);
        JScrollPane scrollPane = new JScrollPane(bookList);
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        addBookButton.addActionListener(e -> {
            String title = titleField.getText();
            String author = authorField.getText();
            Genre genre = (Genre) genreComboBox.getSelectedItem();
            String pageNumber = pageNumberField.getText();
            Language language = (Language) languageComboBox.getSelectedItem();
            String publisher = publisherField.getText();
            String publishedYear = publishedYearField.getText();

            if (title.isEmpty() || author.isEmpty() || genre == null || pageNumber.isEmpty()
                    || language == null || publisher.isEmpty() || publishedYear.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all the required fields!");
                return;
            }

            try {
                int pages = Integer.parseInt(pageNumber);
                int year = Integer.parseInt(publishedYear);
                Book newBook = BookFactory.createBook(title, author, genre, pages, language, publisher, year);
                bookListModel.addElement(newBook);

                titleField.setText("");
                authorField.setText("");
                pageNumberField.setText("");
                publisherField.setText("");
                publishedYearField.setText("");
            } catch (NumberFormatException exc){
                JOptionPane.showMessageDialog(frame, "Invalid input! The [Page Number] and [Published Year] values have to be numbers.");
            }
        });
        removeBookButton.addActionListener(e -> {
            int selectedIndex = bookList.getSelectedIndex();
            if (selectedIndex != -1) {
                bookListModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a book to remove.");
            }
        });

        frame.setVisible(true);
    }
}
