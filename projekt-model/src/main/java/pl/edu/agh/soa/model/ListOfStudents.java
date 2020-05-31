package pl.edu.agh.soa.model;

import java.util.ArrayList;
import java.util.List;

//@Singleton
public class ListOfStudents {
    private List<Student> students = createList();

    public ListOfStudents(){}
/*
    @PostConstruct
    public void init() {
        this.students = createList();
    }
*/
    public List<Student> getStudents() {
        return students;
    }

    public boolean addStudent(Student student){
        return students.add(student);
    }

    public boolean deleteStudentByIndeX(int index){
        return students.removeIf(student -> student.getIndex() == index);
    }

    public boolean deleteStudentByName(String name){
        return students.removeIf(student -> student.getName().equals(name));
    }

    public Student getStudentByIndex(int index){
        for (Student student : students){
            if(student.getIndex() == index){
                return student;
            }
        }
        return null;
    }

    public List<Student> getStudentByName(String name){
        List<Student> result = new ArrayList<>();
        for(Student student : students){
            if(student.getName().equals(name)){
                result.add(student);
            }
        }
        return result;
    }

    public List<Student> getStudentByAge(int age){
        List<Student> result = new ArrayList<>();
        for(Student student : students){
            if(student.getAge() == age){
                result.add(student);
            }
        }
        return result;
    }

    private List<Student> createList(){
        List<Student> list = new ArrayList<>();
        List<String> courses = new ArrayList<>();
        List<Courses> subjects = new ArrayList<>();
        subjects.add(Courses.createCourse("Przyklad1"));
        subjects.add(Courses.createCourse("Przyklad2"));
        subjects.add(Courses.createCourse("Przyklad3"));
        List<Articles> articles = new ArrayList<>();
        articles.add(new Articles("How to pass SOA?"));

        courses.add("Studio Projektowe");
        courses.add("Interfejsy multiomodalne");
        courses.add("SOA w projektowaniu i implementacji oprogramowania");

        list.add(new Student(297242, "Maciej Kutyła", 21, courses, new Adres("Smietanki 23b"), subjects, articles, new HomeTown("26-900")));
        list.add(new Student(297225, "Hubert Kompanowski", 22, courses, new Adres("Izbica Kujawska"), subjects, articles, new HomeTown("12-450")));

        return list;
    }

}