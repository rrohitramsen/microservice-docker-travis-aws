package com.demo.bookservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    private static Map<String, List<Book>> bookRecords;

    static {
        bookRecords = new HashMap<>();

        List<Book> books1 = new ArrayList<>();
        Book book1 = new Book("2019", "Book-1");
        books1.add(book1);
        Book book2 = new Book("2019", "Book-2");
        books1.add(book2);

        bookRecords.put("Author-1", books1);

        List<Book> books2 = new ArrayList<>();
        Book book3 = new Book("2019", "Book-3");
        books2.add(book1);
        Book book4 = new Book("2019", "Book-4");
        books2.add(book2);

        bookRecords.put("Author-2", books2);

    }

    @RequestMapping(value = "/books/{authorName}", method = RequestMethod.GET)
    public ResponseEntity getBooksForAuthor(@PathVariable String authorName) {
        System.out.println("Getting Book details for " + authorName);

        List<Book> books = bookRecords.get(authorName);
        if (books == null) {
            return new ResponseEntity("No record found", HttpStatus.OK);
        }
        return new ResponseEntity(books, HttpStatus.OK);
    }

}
