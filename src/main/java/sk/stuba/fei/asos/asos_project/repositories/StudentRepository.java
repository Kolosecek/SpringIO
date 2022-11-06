package sk.stuba.fei.asos.asos_project.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.asos.asos_project.student.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

}
