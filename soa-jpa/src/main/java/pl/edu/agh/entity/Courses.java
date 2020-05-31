package pl.edu.agh.entity;


import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Courses {

    @Id
    @GeneratedValue
    @Column(name = "courseId")
    private int id;

    @Column(name = "courseName")
    private String courseName;

    public Courses() {
    }

    public Courses(String courseName) {
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
