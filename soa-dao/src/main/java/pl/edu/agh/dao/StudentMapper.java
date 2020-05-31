package pl.edu.agh.dao;

import pl.edu.agh.entity.StudentEntity;
import pl.edu.agh.soa.model.Student;

public class StudentMapper {

    public static StudentEntity modelToEntity(Student student){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(student.getIndex());
        studentEntity.setName(student.getName());
        studentEntity.setAge(student.getAge());
        return studentEntity;
    }

    public static Student entityToModel(StudentEntity studentEntity){
        return new Student(
                studentEntity.getId(),
                studentEntity.getName(),
                studentEntity.getAge()
        );
    }
}
