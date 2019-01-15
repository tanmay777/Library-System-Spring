package com.example.library_system.services;

import com.example.library_system.entities.BookEntityModel;

import java.util.Optional;

public interface BookService {

    int createBook( String bookName,String author) ;

    Optional<BookEntityModel> getBook(Long id);

    int deleteBook(Long id) ;

    int updateBook(Long id,String name) ;
}
