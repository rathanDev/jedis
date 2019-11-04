package org.jana.jedis.service;

import org.jana.jedis.repository.CourseRepository;
import org.jana.jedis.request.SaveCourseRequest;
import org.jana.jedis.request.UpdateCourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.jana.jedis.document.Course;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CourseService {

    private static final Logger log = Logger.getLogger(CourseService.class.getName());

    @Autowired
    private CourseRepository courseRepository;

    @Cacheable(value = "mongo_courses", unless = "#result == null")
    public List<Course> getAll() {
        log.info("Get all courses");
        return courseRepository.findAll();
    }

    @CachePut(value = "mongo_courses", key = "#courseId")
    public Course getById(String courseId) {
        log.info("Get course by bid");
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        return courseOptional.get();
    }

    @CacheEvict(allEntries = true, value = "mongo_courses")
    public Course save(SaveCourseRequest request) {
        log.info("Save course");
        Course course = new Course();
        course.setCourseId(request.getId());
        course.setName(request.getName());
        return courseRepository.save(course);
    }

    @CacheEvict(allEntries = true, value = "mongo_courses")
    public Course update(String courseId, UpdateCourseRequest request) {
        log.info("Update course");
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        Course course = optionalCourse.get();
        course.setName(request.getName());
        return  courseRepository.save(course);
    }

}
