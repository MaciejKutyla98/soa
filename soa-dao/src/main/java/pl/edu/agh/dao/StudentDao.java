package pl.edu.agh.dao;

import pl.edu.agh.entity.ArticlesEntity;
import pl.edu.agh.entity.StudentEntity;
import pl.edu.agh.soa.model.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class StudentDao {

    @PersistenceContext(unitName = "soa")
    private EntityManager entityManager;


    //zapis
    public void save(Student student){
        entityManager.persist(StudentDao.modelToEntity(student));
    }

    //wyszukiwanie
    public Student finder(Integer id){
        StudentEntity found = entityManager.find(StudentEntity.class, id);
        return StudentDao.entityToModel(found);
    }

    //usuwanie
    public void remove(Integer id){
        StudentEntity found = entityManager.find(StudentEntity.class, id);
        entityManager.remove(found);
    }

    public void  update(Student student){
        entityManager.merge(StudentDao.modelToEntity(student));
    }

    //synchronizacja z bazą
    public void flush(){
        entityManager.flush();
    }

    public List<StudentEntity> findByName(String name){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudentEntity> criteriaQuery = builder.createQuery(StudentEntity.class);
        Root<StudentEntity> root = criteriaQuery.from(StudentEntity.class);
        if(name.isEmpty())
            criteriaQuery.select(root);
        else
            criteriaQuery.select(root).where(builder.equal(root.get( "name"), name));
        TypedQuery<StudentEntity> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public void updateAge(Integer oldAge, Integer newAge){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<StudentEntity> update = builder.createCriteriaUpdate(StudentEntity.class);
        Root<StudentEntity> root = update.from(StudentEntity.class);
        update.set("age", newAge);
        update.where(builder.equal(root.get("age"), oldAge));
        this.entityManager.createQuery(update).executeUpdate();
    }

    public static Student entityToModel(StudentEntity studentEntity){
        Student student;
        List<Courses> courses = new ArrayList<>();
        for(pl.edu.agh.entity.Courses courses1 : studentEntity.getCourses())
            courses.add(CoursesDao.entityToModel(courses1));
        List<Articles> articles = new ArrayList<>();
        for(ArticlesEntity articlesEntity : studentEntity.getArticles())
            articles.add(ArticlesDao.entityToModel(articlesEntity));
        Adres adres = new Adres();
        HomeTown homeTown = new HomeTown();
        student = new Student(
                studentEntity.getName(),
                studentEntity.getAge(),
                studentEntity.getId(),
                courses

        );
        student.setArticles(articles);
        student.setAdres(adres);
        student.setHomeTown(homeTown);

        return student;
    }

    public static StudentEntity modelToEntity(Student student){
        StudentEntity studentEntity = new StudentEntity();
        List<ArticlesEntity> articles = new ArrayList<>();
        for(Articles articles1 : student.getArticles())
            articles.add(ArticlesDao.modelToEntity(articles1));
        studentEntity.setArticles(articles);
        studentEntity.setAge(student.getAge());
        studentEntity.setId(student.getIndex());
        studentEntity.setName(student.getName());
        studentEntity.setHomeTownEntity(HomeTownDao.modelToEntity(student.getHomeTown()));
        studentEntity.setAdresEntity(AdresDao.modelToEntity(student.getAdres()));

        return studentEntity;

    }
}
