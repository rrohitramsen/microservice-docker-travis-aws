package com.demo.bookservice;

public class Book {

    private String year;
    private String bookName;

    public Book(String year, String bookName) {
        this.year = year;
        this.bookName = bookName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
