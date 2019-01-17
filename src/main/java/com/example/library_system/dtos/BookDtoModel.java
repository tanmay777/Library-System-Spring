package com.example.library_system.dtos;

import javax.persistence.*;


//We could also emit the @Table annotation.
//Then it would have assumed the class name as the table's name.
//We could have also emitted @Column annotation. In that case,
// it would have assumed that the column name are same as the name off the variable

@Entity
@Table(name="Book")
public class BookDtoModel{

    @Column(name = "Name", nullable = false)
    String bookName;

    @Column(name = "Author", nullable = false)
    String author;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long bookId;

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public Long getBookId() {
        return bookId;
    }

    public BookDtoModel() {
    }

    public BookDtoModel(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

}
