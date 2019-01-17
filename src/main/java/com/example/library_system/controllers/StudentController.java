package com.example.library_system.controllers;

import com.example.library_system.models.ServerResponseEntityModel;
import com.example.library_system.entities.StudentEntityModel;
import com.example.library_system.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ServerResponseEntityModel createStudent(@RequestParam(value = "name") String name) {
        int result = studentService.createStudent(name);
        System.out.println(name);

        if (result == 1) {
            return new ServerResponseEntityModel(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            return new ServerResponseEntityModel(ERROR_STATUS, AUTH_FAILURE);
        }
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String greeting(){
        return "Working";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getStudent(@RequestParam(value = "id") Long id) {
        Optional<StudentEntityModel> studentEntityModel=studentService.getStudent(id);
        if(studentEntityModel.isPresent())
            return "name:" +studentEntityModel.get().getName() + "\nid: "+studentEntityModel.get().getStudentId()+ "\nrentedBookId: "+studentEntityModel.get().getRentedBookId();
        else
            return "No Such Student Exists";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ServerResponseEntityModel deleteStudent(@RequestParam(value = "id") Long id) {
        int result = studentService.deleteStudent(id);

        if (result == 1) {
            return new ServerResponseEntityModel(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            return new ServerResponseEntityModel(ERROR_STATUS, AUTH_FAILURE);
        }
    }

    @RequestMapping(value = "/updateRentedBook", method = RequestMethod.PUT)
    public ServerResponseEntityModel updateRentedBook(@RequestParam(value = "student_id") Long student_id,@RequestParam(value = "book_id") Long book_id) {

        int result = studentService.updateRentedBook(student_id,book_id);
        if (result == 1) {
            return new ServerResponseEntityModel(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            return new ServerResponseEntityModel(ERROR_STATUS, AUTH_FAILURE);
        }
    }

    @RequestMapping(value = "/updateName", method = RequestMethod.PUT)
    public ServerResponseEntityModel updateName(@RequestParam(value = "id") Long id,@RequestParam(value = "name") String name) {

        int result = studentService.updateName(id,name);
        if (result == 1) {
            return new ServerResponseEntityModel(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            return new ServerResponseEntityModel(ERROR_STATUS, AUTH_FAILURE);
        }
    }

}