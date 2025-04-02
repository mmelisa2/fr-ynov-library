package fr.ynov.library.gui.buttons;

import fr.ynov.library.domain.Book;

import javax.swing.*;

public class RemoveBookButton extends JButton {
    private final DefaultListModel<Book> bookListModel;
    private final JList<Book> bookList;
    private final JFrame parentFrame;

    public RemoveBookButton(DefaultListModel<Book> bookListModel, JList<Book> bookList, JFrame parentFrame) {
        super("Remove Book");
        this.bookListModel = bookListModel;
        this.bookList = bookList;
        this.parentFrame = parentFrame;

        addActionListener(e -> removeSelectedBook());
    }

    private void removeSelectedBook() {
        int selectedIndex = bookList.getSelectedIndex();
        if (selectedIndex != -1) {
            bookListModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(parentFrame, "Please select a book to remove.");
        }
    }
}