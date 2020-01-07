package org.jana.jedis.service;

import org.jana.jedis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;
import org.jana.jedis.document.Student;
import org.jana.jedis.request.SaveStudentRequest;
import org.jana.jedis.request.UpdateStudentRequest;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

@Service
public class StudentService {

    private static final Logger log = Logger.getLogger(StudentService.class.getName());

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Cacheable(value = "mongo_students", unless = "#result == null")
    public List<Student> getAll() {
        log.info("Get all students");
        return studentRepository.findAll();
    }

    @CachePut(value = "mongo_students", key = "#studentId")
    public Student getById(String studentId) {
        log.info("Get student by id");
        return studentRepository.findById(studentId).get();
    }

    public List<Student> getAllFromDb() {
        log.info("Get all students from db");
        return studentRepository.findAll();
    }

    @CacheEvict(allEntries = true, value = "mongo_students")
    public Student save(SaveStudentRequest request) {
        log.info("Save student");
        Student student = new Student();
        student.setStudentId(request.getId());
        student.setName(request.getName());
        return studentRepository.save(student);
    }

    @CacheEvict(allEntries = true, value = "mongo_students")
    public Student update(String studentId, UpdateStudentRequest request) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Student student = studentOptional.get();
        student.setName(request.getName());
        return studentRepository.save(student);
    }

    @CacheEvict(allEntries = true, value = "mongo_students")
    public String clearCache() {
        log.info("Clear jedis");
        return "Cache cleared";
    }

    public void doAggregation() {
        GroupOperation sumZips = group("state").count().as("zipCount");
        SortOperation sortByCount = sort(Sort.Direction.ASC, "zipCount");
        GroupOperation groupFirstAndLast = group().first("_id").as("minZipState")
                .first("zipCount").as("minZipCount").last("_id").as("maxZipState")
                .last("zipCount").as("maxZipCount");

        Aggregation aggregation = newAggregation(sumZips, sortByCount, groupFirstAndLast);

        AggregationResults<Document> result = mongoTemplate
                .aggregate(aggregation, "zips", Document.class);
        Document document= result.getUniqueMappedResult();
    }

}
