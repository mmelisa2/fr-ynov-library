package fr.ynov.library.gui.panels;

import fr.ynov.library.domain.Genre;
import fr.ynov.library.domain.Language;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {
    private final JTextField titleField;
    private final JTextField authorField;
    private final JComboBox<Genre> genreComboBox;
    private final JTextField pageNumberField;
    private final JComboBox<Language> languageComboBox;
    private final JTextField publisherField;
    private final JTextField publishedYearField;

    public InputPanel() {
        setLayout(new GridLayout(8, 2, 5, 5));

        titleField = new JTextField();
        authorField = new JTextField();
        genreComboBox = new JComboBox<>(Genre.values());
        pageNumberField = new JTextField();
        languageComboBox = new JComboBox<>(Language.values());
        publisherField = new JTextField();
        publishedYearField = new JTextField();

        add(new JLabel("Title:"));
        add(titleField);
        add(new JLabel("Author:"));
        add(authorField);
        add(new JLabel("Genre:"));
        add(genreComboBox);
        add(new JLabel("Page Number:"));
        add(pageNumberField);
        add(new JLabel("Language:"));
        add(languageComboBox);
        add(new JLabel("Publisher:"));
        add(publisherField);
        add(new JLabel("Published Year:"));
        add(publishedYearField);
    }

    public String getTitle() {
        return titleField.getText();
    }

    public String getAuthor() {
        return authorField.getText();
    }

    public Genre getGenre() {
        return (Genre) genreComboBox.getSelectedItem();
    }

    public String getPageNumber() {
        return pageNumberField.getText();
    }

    public Language getLanguage() {
        return (Language) languageComboBox.getSelectedItem();
    }

    public String getPublisher() {
        return publisherField.getText();
    }

    public String getPublishedYear() {
        return publishedYearField.getText();
    }

    public void clearFields() {
        titleField.setText("");
        authorField.setText("");
        pageNumberField.setText("");
        publisherField.setText("");
        publishedYearField.setText("");
    }
}