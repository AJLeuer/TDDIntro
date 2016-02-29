package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {

    private Library library ;
    private PrintStream mockPrintStream;
    private DateTimeFormatter mockDateTimeFormatter;

    /*
        List books tests. Implement the first three tests for the Verify exercise
     */
    @Before
    public void setUp() {
        setUp(mock(PrintStream.class), mock(DateTimeFormatter.class));
    }

    public void setUp(PrintStream stream, DateTimeFormatter formatter) {
        List<String> books = new ArrayList<String>();
        this.mockPrintStream = stream ;
        this.mockDateTimeFormatter = formatter ;
        this.library = new Library(books, stream, formatter) ;
    }


    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        List<String> books = new ArrayList<>();
        String title = "Book Title";
        books.add(title);

        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);

        library = new Library(books, mockPrintStream, dateTimeFormatter);

        library.listBooks();

        // add a verify statement here that shows that the book title was printed by to the mockPrintStream
        verify(mockPrintStream).println("Book Title") ;
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        // implement me

        library.listBooks();

        //verify
        verify(mockPrintStream).println("") ;
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {


        BufferedReader reader = mock(BufferedReader.class);

        when(reader.readLine()).thenReturn("1", "2");

        // implement me
        List<String> twoBooks = new ArrayList<String>() ;
        twoBooks.add("Book 1") ;
        twoBooks.add("Book 2") ;

        this.library = new Library(twoBooks, this.mockPrintStream, this.mockDateTimeFormatter) ;

        library.listBooks();

        verify(mockPrintStream).println(contains("Book 1")) ;
        verify(mockPrintStream).println(contains("Book 2")) ;
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
        DateTime time = new DateTime() ;
        when(mockDateTimeFormatter.print(time)).thenReturn("2013-04-08 16:33:17") ;

        library.welcome(time) ;

        verify(mockPrintStream).println(contains("2013-04-08 16:33:17")) ;
    }
}