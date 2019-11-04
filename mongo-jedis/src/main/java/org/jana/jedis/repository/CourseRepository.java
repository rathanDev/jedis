package org.jana.jedis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.jana.jedis.document.Course;

public interface CourseRepository extends MongoRepository<Course, String> {
}
