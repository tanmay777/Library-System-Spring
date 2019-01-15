package com.example.library_system.controllers;

import com.example.library_system.entities.ServerResponseEntityModel;
import com.example.library_system.entities.StudentEntityModel;
import com.example.library_system.services.BookService;
import com.example.library_system.services.Implementation.BookServiceImplementation;
import com.example.library_system.services.Implementation.StudentServiceImplementation;
import com.example.library_system.services.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ServerResponseEntityModel createStudent(@RequestParam(value = "name") String name) {
        int result = new StudentServiceImplementation().createStudent(name);

        if (result == 1) {
            return new ServerResponseEntityModel(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            return new ServerResponseEntityModel(ERROR_STATUS, AUTH_FAILURE);
        }

    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public StudentEntityModel getStudent(@RequestParam(value = "id") Long id) {
        return new StudentServiceImplementation().getStudent(id).get();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ServerResponseEntityModel deleteStudent(@RequestParam(value = "id") Long id) {
        int result = new StudentServiceImplementation().deleteStudent(id);

        if (result == 1) {
            return new ServerResponseEntityModel(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            return new ServerResponseEntityModel(ERROR_STATUS, AUTH_FAILURE);
        }
    }

    @RequestMapping(value = "/updateRentedBook", method = RequestMethod.PUT)
    public ServerResponseEntityModel updateRentedBook(@RequestParam(value = "student_id") Long student_id,@RequestParam(value = "book_id") Long book_id) {
        ServerResponseEntityModel serverResponseEntityModel = new ServerResponseEntityModel(SUCCESS_STATUS, CODE_SUCCESS);
        return serverResponseEntityModel;
    }

    @RequestMapping(value = "/updateName", method = RequestMethod.PUT)
    public ServerResponseEntityModel updateName(@RequestParam(value = "id") Long id,@RequestParam(value = "name") String name) {
        ServerResponseEntityModel serverResponseEntityModel = new ServerResponseEntityModel(SUCCESS_STATUS, CODE_SUCCESS);
        return serverResponseEntityModel;
    }

}