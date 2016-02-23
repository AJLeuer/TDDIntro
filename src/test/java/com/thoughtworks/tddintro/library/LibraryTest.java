package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {

    private Library library ;
    private PrintStream printStream ;
    private DateTimeFormatter dateTimeFormatter ;

    /*
        List books tests. Implement the first three tests for the Verify exercise
     */
    @Before
    public void setUp() {
        setUp(mock(PrintStream.class), mock(DateTimeFormatter.class));
    }

    public void setUp(PrintStream stream, DateTimeFormatter formatter) {
        List<String> books = new ArrayList<String>();
        printStream = stream ;
        dateTimeFormatter = formatter ;

        library = new Library(books, stream, formatter) ;
    }


    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        List<String> books = new ArrayList<>();
        String title = "Book Title";
        books.add(title);

        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);

        library = new Library(books, printStream, dateTimeFormatter);

        library.listBooks();

        // add a verify statement here that shows that the book title was printed by to the printStream
        verify(printStream).println("Book Title") ;
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        // implement me
        setUp() ; //should reset library with no books
        library.listBooks();

        //verify
        verify(printStream).println("") ;
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {


        BufferedReader reader = mock(BufferedReader.class);

        when(reader.readLine()).thenReturn("1", "2");

        // implement me
        // ? a little confused about what's expected here
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        List<String> books = new ArrayList<>();
        PrintStream printStream = mock(PrintStream.class);
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);
        Library library = new Library(books, printStream, dateTimeFormatter);

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        DateTime time = new DateTime();
        
        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {
        List<String> books = new ArrayList<>();
        PrintStream printStream = mock(PrintStream.class);
        DateTime time = new DateTime();
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);

        when(dateTimeFormatter.print(time)).thenReturn("");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        // add a verify here
        verify(dateTimeFormatter).print(time) ;
    }


    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {
        // implement me
        // then move common test variables into a setup method
        setUp() ;
        DateTime time = new DateTime() ;
        when(dateTimeFormatter.print(time)).thenReturn("2013-04-08 16:33:17") ;

        library.welcome(time) ;

        verify(printStream).println(contains("2013-04-08 16:33:17")) ;
    }
}