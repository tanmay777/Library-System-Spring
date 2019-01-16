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
            System.out.println(studentEntityModel);
            studentRepository.save(studentEntityModel);
            return 1;
        } catch (Exception e) {
            System.out.println(e.toString());
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
            if(studentRepository.existsById(id))
                studentRepository.deleteById(id);
            else{
                System.out.println("Student of this id does not exists");
            }
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
            if(studentEntityModel.isPresent()) {
                studentEntityModel.get().setRentedBookId(book_id);
                studentRepository.save(studentEntityModel.get());
            }
            else {
                System.out.println("Student of this id does not exists");
            }
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
            if(studentEntityModel.isPresent()) {
                studentEntityModel.get().setName(name);
                studentRepository.save(studentEntityModel.get());
            }
            else {
                System.out.println("Student of this id does not exists");
            }
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
