package com.example.library_system.entities;

public class BookEntityModel {
    String bookName;
    String author;
    int bookId;

    public BookEntityModel(String bookName, String author, int bookId) {
        this.bookName = bookName;
        this.author = author;
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
