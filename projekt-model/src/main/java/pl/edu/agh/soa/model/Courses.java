package pl.edu.agh.soa.model;

import java.util.HashMap;
import java.util.Map;

public class Courses {
    private String name;

    public Courses() {
    }

    public Courses(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static Map<String, Courses> courses = new HashMap<>();
    public static Courses createCourse(String name) {
        Courses course = new Courses(name);
        courses.put(name, course);
        return course;
    }
}
