package com.example.library_system.convertors;

import com.example.library_system.bos.StudentBoModel;
import com.example.library_system.entities.StudentEntityModel;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentBoModel studentEntityToStudentBoMapper(StudentEntityModel studentEntityModel);

    StudentEntityModel studentBoToStudentEntity(StudentBoModel studentBoModel);
}
