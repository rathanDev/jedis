package org.jana.jedis.document;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Course implements Serializable {

    @Id
    private String courseId;

    private String name;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
