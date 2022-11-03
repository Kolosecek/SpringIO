package com.example.springio.repositories;

import com.example.springio.classes.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

//TODO: tu sa budu pridavat custom metody, ide to priame cez Mongo, mozno to asi nebude ani treba upravovat
@Repository
public interface StudentRepository extends MongoRepository<Student, Long> {

    @Query("{name:'?0'}")
    Student findStudentByName(String name);

}
