package com.example.library_system.services;

import com.example.library_system.entities.StudentEntityModel;

import java.util.Optional;

public interface StudentService {

    int createStudent(String name);

    Optional<StudentEntityModel> getStudent(Long id);

    int deleteStudent(Long id);

    int updateRentedBook(Long student_id,Long book_id);

    int updateName(Long id, String name);
}
