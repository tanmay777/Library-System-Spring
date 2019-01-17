package com.example.library_system.repositories;

import com.example.library_system.entities.BookEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntityModel, Long> {

}
