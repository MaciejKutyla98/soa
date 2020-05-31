package pl.edu.agh.entity;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class ArticlesEntity {

    @Id
    @GeneratedValue
    @Column(name = "articleId")
    private int id;

    @Column(name = "tittle")
    private String tittle;


    @ManyToOne
    @JoinColumn(name="student_id", nullable = false)
    private StudentEntity studentEntity;

    public ArticlesEntity(String tittle) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }
}
