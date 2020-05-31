package pl.edu.agh.soa.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = {"index", "name", "age", "avatar", "courses", "adres", "subjects","articles","homeTown"})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Student {
    private int index;
    private String name;
    private int age;
    private String avatar;
    private List<String> courses = new ArrayList<>();


    private Adres adres = null;
    private List<Courses> subjects = new ArrayList<>();
    private List<Articles> articles = new ArrayList<>();
    private HomeTown homeTown = null;

    public Student(int index, String name, int age) {
        this.index = index;
        this.name = name;
        this.age = age;
    }

    public Student(int index, String name, int age, List<String> courses) {
        this.index = index;
        this.name = name;
        this.age = age;
        this.courses = courses;
        avatar = "avatar.jpg";
    }

    public Student(int index, String name, int age, List<String> courses, Adres adres, List<Courses> subjects, List<Articles> articles, HomeTown homeTown) {
        this.index = index;
        this.name = name;
        this.age = age;
        this.courses = courses;
        this.adres = adres;
        this.subjects = subjects;
        this.articles = articles;
        this.homeTown = homeTown;
    }

    public Student(){
    }

    public Student(String name, Integer age, Integer id, List<Courses> courses) {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public List<Courses> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Courses> subjects) {
        this.subjects = subjects;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    public HomeTown getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(HomeTown homeTown) {
        this.homeTown = homeTown;
    }


    @XmlElementWrapper(name = "courses")
    @XmlElement(name = "course")
    @JsonProperty("courses")
    public List<String> getCourses() {
        return courses;
    }

    public void addCourse(String courseName){
        courses.add(courseName);
    }

}
