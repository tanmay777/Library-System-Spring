package com.example.library_system.entities;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class StudentEntityModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;

    @Column(name = "Name",nullable = false)
    private String name;

    @Column(name = "rentedBookId",nullable = false)
    private Long rentedBookId;

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRentedBookId(Long rentedBookId) {
        this.rentedBookId = rentedBookId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public Long getRentedBookId() {
        return rentedBookId;
    }

    public StudentEntityModel() {
    }

    public StudentEntityModel(String name, Long rentedBookId) {
        this.name = name;
        this.rentedBookId = rentedBookId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
