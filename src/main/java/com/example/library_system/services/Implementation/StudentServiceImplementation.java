package com.example.library_system.services.Implementation;

import com.example.library_system.entities.StudentEntityModel;
import com.example.library_system.repositories.StudentRepository;
import com.example.library_system.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public int createStudent(String name) {

        try {
            StudentEntityModel studentEntityModel = new StudentEntityModel(name, 0L);
            studentRepository.save(studentEntityModel);
            return 1;
        } catch (Exception e) {
            return 0;
        }

    }

    @Override
    public Optional<StudentEntityModel> getStudent(Long id) {

        Optional<StudentEntityModel> studentEntityModel = studentRepository.findById(id);
        return studentEntityModel;

    }

    @Override
    public int deleteStudent(Long id) {
        try {
            studentRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int updateRentedBook(Long student_id, Long book_id) {
        try {
            Optional<StudentEntityModel> studentEntityModel = studentRepository.findById(student_id);
            //Add condition to ensure that the studentEntityModel is present
            studentEntityModel.get().setRentedBookId(book_id);
            studentRepository.save(studentEntityModel.get());
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int updateName(Long id, String name) {
        try {
            Optional<StudentEntityModel> studentEntityModel = studentRepository.findById(id);
            //Add condition to ensure that the studentEntityModel is present
            studentEntityModel.get().setName(name);
            studentRepository.save(studentEntityModel.get());
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
