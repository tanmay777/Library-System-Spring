package com.example.library_system.repositories;


import com.example.library_system.entities.StudentEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntityModel,Long>{

}
