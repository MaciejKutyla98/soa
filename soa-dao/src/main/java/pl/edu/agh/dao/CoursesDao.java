package pl.edu.agh.dao;

import pl.edu.agh.entity.Courses;

public class CoursesDao {

    public static Courses modelToEntity(pl.edu.agh.soa.model.Courses courses){
        return new Courses(courses.getName());
    }

    public static pl.edu.agh.soa.model.Courses entityToModel(Courses courses){
        return new pl.edu.agh.soa.model.Courses(courses.getCourseName());
    }
}
