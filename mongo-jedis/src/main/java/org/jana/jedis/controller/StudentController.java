package org.jana.jedis.controller;

import org.jana.jedis.document.Student;
import org.jana.jedis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.jana.jedis.request.SaveStudentRequest;
import org.jana.jedis.request.UpdateStudentRequest;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/all-from-db")
    public ResponseEntity<List<Student>> getAllStudentsFromDb() {
        List<Student> students = studentService.getAllFromDb();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId") String studentId) {
        Student student = studentService.getById(studentId);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/save")
    public Student save(@RequestBody SaveStudentRequest request) {
        return studentService.save(request);
    }

    @PutMapping("/update/{studentId}")
    public Student updateStudent(@PathVariable("studentId") String studentId, @RequestBody UpdateStudentRequest request) {
        return studentService.update(studentId, request);
    }

    @GetMapping("/clear-cache")
    public String clearCache() {
        return studentService.clearCache();
    }

}
