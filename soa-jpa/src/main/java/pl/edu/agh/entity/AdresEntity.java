package pl.edu.agh.entity;

import javax.persistence.*;

@Entity
@Table(name = "adres")
public class AdresEntity {
    @Id
    @GeneratedValue
    @Column(name = "adresId")
    private int id;

    @Column(name = "adres")
    private String adres;

    @OneToOne(mappedBy = "adresEntity", cascade = CascadeType.ALL)
    private StudentEntity studentEntity;

    public AdresEntity(String adres) {
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
