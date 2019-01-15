package com.example.library_system.controllers;

import com.example.library_system.entities.BookEntityModel;
import com.example.library_system.entities.ServerResponseEntityModel;
import com.example.library_system.services.Implementation.BookServiceImplementation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ServerResponseEntityModel createBook(@RequestParam(value = "name") String name,@RequestParam(value = "author") String author) {
        int result= new BookServiceImplementation().createBook(name,author);
        if (result == 1) {
            return new ServerResponseEntityModel(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            return new ServerResponseEntityModel(ERROR_STATUS, AUTH_FAILURE);
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public BookEntityModel getBook(@RequestParam(value = "id") Long id) {
        return new BookServiceImplementation().getBook(id).get();

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ServerResponseEntityModel deleteBook(@RequestParam(value = "id") Long id) {
        int result = new BookServiceImplementation().deleteBook(id);
        if (result == 1) {
            return new ServerResponseEntityModel(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            return new ServerResponseEntityModel(ERROR_STATUS, AUTH_FAILURE);
        }
    }

    @RequestMapping(value = "/updateName", method = RequestMethod.PUT)
    public ServerResponseEntityModel updateName(@RequestParam(value = "id") Long id,@RequestParam(value = "name") String name) {
        int result = new BookServiceImplementation().updateBook(id,name);
        if (result == 1) {
            return new ServerResponseEntityModel(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            return new ServerResponseEntityModel(ERROR_STATUS, AUTH_FAILURE);
        }

    }
}
