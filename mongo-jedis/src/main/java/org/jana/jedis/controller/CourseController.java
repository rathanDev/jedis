package org.jana.jedis.controller;

import org.jana.jedis.document.Course;
import org.jana.jedis.request.SaveCourseRequest;
import org.jana.jedis.request.UpdateCourseRequest;
import org.jana.jedis.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getCourses() {
        List<Course> all = courseService.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourse(@PathVariable("courseId") String courseId) {
        Course course = courseService.getById(courseId);
        return ResponseEntity.ok(course);
    }

    @PostMapping("/save")
    public ResponseEntity<Course> save(@RequestBody SaveCourseRequest request) {
        Course course = courseService.save(request);
        return ResponseEntity.ok(course);
    }

    @PostMapping("/update/{courseId}")
    public ResponseEntity<Course> update(@PathVariable("courseId") String courseId, @RequestBody UpdateCourseRequest request) {
        Course course = courseService.update(courseId, request);
        return ResponseEntity.ok(course);
    }

}
