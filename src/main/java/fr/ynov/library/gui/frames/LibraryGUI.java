package fr.ynov.library.gui.frames;

import fr.ynov.library.domain.Book;
import fr.ynov.library.domain.Library;
import fr.ynov.library.factory.LibraryFactory;
import fr.ynov.library.gui.buttons.AddBookButton;
import fr.ynov.library.gui.buttons.RemoveBookButton;
import fr.ynov.library.gui.panels.InputPanel;
import fr.ynov.library.gui.panels.ReadingStatusPanel;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("FieldCanBeLocal")

public class LibraryGUI {
    private final Library library;
    private final JFrame frame;
    private final DefaultListModel<Book> bookListModel;
    private final JList<Book> bookList;
    public LibraryGUI() {
        library = LibraryFactory.createLibrary();
        frame = new JFrame("Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(new BorderLayout());

        InputPanel inputPanel = new InputPanel();

        bookListModel = new DefaultListModel<>();
        bookList = new JList<>(bookListModel);
        JScrollPane scrollPane = new JScrollPane(bookList);

// Initializing and adding the buttons to add and remove books
        AddBookButton addBookButton = new AddBookButton(bookListModel, inputPanel, frame);
        RemoveBookButton removeBookButton = new RemoveBookButton(bookListModel, bookList, frame);

        ReadingStatusPanel readingStatusPanel = new ReadingStatusPanel(bookList, bookListModel, frame);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(addBookButton);
        buttonPanel.add(removeBookButton);
        inputPanel.add(buttonPanel);

        //Adding the existing frames
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(readingStatusPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public Library getLibrary() {
        return library;
    }
}