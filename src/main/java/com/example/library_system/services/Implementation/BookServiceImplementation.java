package com.example.library_system.services.Implementation;

import com.example.library_system.entities.BookEntityModel;
import com.example.library_system.repositories.BookRepository;
import com.example.library_system.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImplementation implements BookService {


    @Autowired
    BookRepository bookRepository;

    @Override
    public int createBook(String bookName,String author) {
        try {
            BookEntityModel bookEntityModel = new BookEntityModel(bookName,author);
            bookRepository.save(bookEntityModel);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Optional<BookEntityModel> getBook(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public int deleteBook(Long id) {
        try {
            bookRepository.delete(bookRepository.findById(id).get());
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int updateBook(Long id, String name) {
        try {
            BookEntityModel bookEntityModel=bookRepository.findById(id).get();
            bookEntityModel.setBookName(name);
            bookRepository.save(bookEntityModel);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
