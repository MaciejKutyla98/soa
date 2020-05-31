package pl.edu.agh.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @Column(name = "id")
    public Integer id;

    @Column(name = "name")
    public String name;

    @Column(name = "age")
    private Integer age;

    @OneToMany(mappedBy = "studentEntity")
    private List<ArticlesEntity> articles;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "courseId"))
    private List<Courses> courses;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "homeId")
    private HomeTownEntity homeTownEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private AdresEntity adresEntity;


    public StudentEntity() {
    }

    public AdresEntity getAdresEntity() {
        return adresEntity;
    }

    public void setAdresEntity(AdresEntity adresEntity) {
        this.adresEntity = adresEntity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<ArticlesEntity> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticlesEntity> articles) {
        this.articles = articles;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    public HomeTownEntity getHomeTownEntity() {
        return homeTownEntity;
    }

    public void setHomeTownEntity(HomeTownEntity homeTownEntity) {
        this.homeTownEntity = homeTownEntity;
    }
}
