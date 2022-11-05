package sk.stuba.fei.asos.asos_project.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.asos.asos_project.student.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    @Query("{ 'name' : ?0 }")
    Student findStudentByName(String name);
}
