package com.thoughtworks.tddintro.voidmethods;

import java.util.Collection;

public class BookBanner {

    private Library library ;

    public BookBanner(Library library) {
        this.library = library ;
    }

    public void remove(Collection<String> bannedBooks) {
        for (String book: bannedBooks) {
            library.removeBook(book);
        }
    }
}
