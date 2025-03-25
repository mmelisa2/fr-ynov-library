package fr.ynov.library.factory;

import fr.ynov.library.domain.Library;

public class LibraryFactory {
    public static Library createLibrary() {
        return new Library();
    }
}
