package com.example.library_system.entities;

import javax.persistence.*;


//We could also emit the @Table annotation.
//Then it would have assumed the class name as the table's name.
//We could have also emitted @Column annotation. In that case,
// it would have assumed that the column name are same as the name off the variable

@Entity
@Table(name="Book")
public class BookEntityModel {

    public BookEntityModel() {
    }
    //This constructor will be used by JPA

    @Column(name = "Name", nullable = false)
    String bookName;

    @Column(name = "Author", nullable = false)
    String author;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long bookId;

    public BookEntityModel(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
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

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
