package fr.ynov.library.gui.panels;

import fr.ynov.library.domain.Book;
import fr.ynov.library.domain.ReadingStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadingStatusPanel extends JPanel {
    private final JComboBox<ReadingStatus> statusComboBox;
    private final JButton updateStatusButton;
    private final JList<Book> bookList;
    private final DefaultListModel<Book> bookListModel;
    private final JFrame parentFrame;

    //Setting up the panel and initializing the status combo box and the update status button
    public ReadingStatusPanel(JList<Book> bookList, DefaultListModel<Book> bookListModel, JFrame parentFrame) {
        this.bookList = bookList;
        this.bookListModel = bookListModel;
        this.parentFrame = parentFrame;
        setLayout(new FlowLayout());
        statusComboBox = new JComboBox<>(ReadingStatus.values());
        updateStatusButton = new JButton("Update Reading Status");

        updateStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBookStatus();
            }
        });

       //When a book is selected, the status combo box is updated with this addListSelectionListener.
        bookList.addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) {
                Book selectedBook = bookList.getSelectedValue();
                if (selectedBook != null) {
                    statusComboBox.setSelectedItem(selectedBook.getReadingStatus());
                }
            }
        });

        add(statusComboBox);
        add(updateStatusButton);
    }
    private void updateBookStatus() {
        //Getting chosen book and the new reading status
        Book selectedBook = bookList.getSelectedValue();
        ReadingStatus newStatus = (ReadingStatus) statusComboBox.getSelectedItem();

        if (selectedBook == null) {
            JOptionPane.showMessageDialog(parentFrame, "Please select a book in order to update its status", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        selectedBook.setReadingStatus(newStatus);

        int selectedIndex = bookList.getSelectedIndex();
        bookListModel.set(selectedIndex, selectedBook);

        //Notifying the user that they have changed the reading status.
        JOptionPane.showMessageDialog(parentFrame, "Reading status for " + selectedBook.getTitle() + " changed to: " + newStatus);
    }
}