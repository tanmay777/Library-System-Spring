package com.example.library_system.services.Implementations;

import com.example.library_system.bos.StudentBoModel;
import com.example.library_system.convertors.StudentMapper;
import com.example.library_system.entities.StudentEntityModel;
import com.example.library_system.repositories.StudentRepository;
import com.example.library_system.services.StudentService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    StudentRepository studentRepository;

//    @Autowired
//    StudentMapper studentMapper;

    //TODO: Check why we cannot @autowire it
    StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);

    @Override
    public int createStudent(String name) {
        try {
            StudentBoModel studentBoModel = new StudentBoModel(name, 0L);
            System.out.println(studentBoModel.toString());
            studentRepository.save(studentMapper.studentBoToStudentEntity(studentBoModel));
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
                StudentBoModel studentBoModel=studentMapper.studentEntityToStudentBoMapper(studentEntityModel.get());
                studentBoModel.setRentedBookId(book_id);
                studentRepository.save(studentMapper.studentBoToStudentEntity(studentBoModel));
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
                StudentBoModel studentBoModel = studentMapper.studentEntityToStudentBoMapper(studentEntityModel.get());
                studentBoModel.setName(name);
                studentRepository.save(studentMapper.studentBoToStudentEntity(studentBoModel));
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


//TODO: Confirm whether the usage of bo here is ok or not.