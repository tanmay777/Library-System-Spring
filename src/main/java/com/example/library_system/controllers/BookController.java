package com.example.library_system.controllers;

import com.example.library_system.entities.ServerResponseEntityModel;
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

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ServerResponseEntityModel createBook(@RequestParam(value = "name") String name){

        ServerResponseEntityModel serverResponseEntityModel = new ServerResponseEntityModel(SUCCESS_STATUS,CODE_SUCCESS);
        return serverResponseEntityModel;
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ServerResponseEntityModel getBook(@RequestParam(value = "id") int id){
        ServerResponseEntityModel serverResponseEntityModel = new ServerResponseEntityModel(SUCCESS_STATUS,CODE_SUCCESS);
        return serverResponseEntityModel;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ServerResponseEntityModel deleteBook(@RequestParam(value = "id") int id){
        ServerResponseEntityModel serverResponseEntityModel = new ServerResponseEntityModel(SUCCESS_STATUS,CODE_SUCCESS);
        return serverResponseEntityModel;
    }

    @RequestMapping(value = "/updateName",method = RequestMethod.PUT)
    public ServerResponseEntityModel updateName(@RequestParam(value = "id") int id){
        ServerResponseEntityModel serverResponseEntityModel = new ServerResponseEntityModel(SUCCESS_STATUS,CODE_SUCCESS);
        return serverResponseEntityModel;
    }
}
