package org.jana.jedis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.jana.jedis.document.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

}
