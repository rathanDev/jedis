package org.jana.jedis.service;

import org.jana.jedis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.jana.jedis.document.Student;
import org.jana.jedis.request.SaveStudentRequest;
import org.jana.jedis.request.UpdateStudentRequest;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class StudentService {

    private static final Logger log = Logger.getLogger(StudentService.class.getName());

    @Autowired
    private StudentRepository studentRepository;

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

}
