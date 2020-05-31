package pl.edu.agh.entity;

import javax.persistence.*;

@Entity
@Table(name = "homeTowns")
public class HomeTownEntity {

    @Id
    @GeneratedValue
    @Column(name ="homeId")
    private Integer id;

    @Column(name = "postalCode")
    private String postalCode;

    public HomeTownEntity() {
    }

    public HomeTownEntity(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
