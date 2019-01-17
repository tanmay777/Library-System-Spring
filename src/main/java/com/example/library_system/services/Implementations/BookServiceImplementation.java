package com.example.library_system.services.Implementations;

import com.example.library_system.bos.BookBoModel;
import com.example.library_system.convertors.BookMapper;
import com.example.library_system.entities.BookEntityModel;
import com.example.library_system.repositories.BookRepository;
import com.example.library_system.services.BookService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImplementation implements BookService {


    @Autowired
    BookRepository bookRepository;

    BookMapper bookMapper= Mappers.getMapper(BookMapper.class);

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
            if(bookRepository.existsById(id)) {
                BookBoModel bookBoModel = bookMapper.bookEntityModelToBookBoModel(bookRepository.findById(id).get());
                bookRepository.delete(bookMapper.bookBoModelToBookEntityModel(bookBoModel));
            }
            else{
                System.out.println("This book does not exists");

            }
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int updateBook(Long id, String name) {
        try {
            if(bookRepository.existsById(id)){
                BookBoModel bookBoModel = bookMapper.bookEntityModelToBookBoModel(bookRepository.findById(id).get());
                bookBoModel.setBookName(name);
                bookRepository.save(bookMapper.bookBoModelToBookEntityModel(bookBoModel));
            }
            else{
                System.out.println("This book does not exists");
            }
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
