package org.jana.jedis.document;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String studentId;

    private String name;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
