package pl.edu.agh.soa.lab;

import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;
import pl.edu.agh.soa.model.ListOfStudents;
import pl.edu.agh.soa.model.Student;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;
import java.util.List;

@Stateless
@WebService
@SecurityDomain("my-security-domain")
@DeclareRoles({"testowa", "admin"})
@WebContext(contextRoot = "/soa", urlPattern = "/Service", authMethod = "BASIC", transportGuarantee = "NONE")
public class Service {


    private ListOfStudents students;
    private String avatarFilepath;

    @WebMethod
    @PermitAll
    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    public List<Student> getStudents(){
        return students.getStudents();
    }

    @WebMethod
    @PermitAll
    @XmlElement(name = "student")
    public Student getStudentByIndex(int index){
        return getStudentByIndex(index);
    }

    @WebMethod
    @RolesAllowed("admin")
    public boolean deleteStudentByIndeX(@WebParam(name = "index") int index){
        return  students.deleteStudentByIndeX(index);
    }

    @WebMethod
    @RolesAllowed("admin")
    public boolean deleteStudentByName(@WebParam(name = "name") String name){
        return students.deleteStudentByName(name);
    }

    @WebMethod
    @PermitAll
    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    public List<Student> getStudentByName(String name){
        return students.getStudentByName(name);
    }

    @WebMethod
    @PermitAll
    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    public List<Student> getStudentByAge(int age){
        return students.getStudentByAge(age);
    }

    @WebMethod
    @RolesAllowed("admin")
    @XmlElement(name = "student")
    public Student addNewStudent(@WebParam(name = "index") int index,@WebParam(name = "name") String name,@WebParam(name = "age") int age){
        Student newStudent = null;
        if(students.getStudentByIndex(index) == null){
            newStudent = new Student(index, name, age);
            students.addStudent(newStudent);
        }
        return newStudent;
    }

    @WebMethod
    @PermitAll
    public String getBase64Avatar(@WebParam(name = "index") int index) {
        Student student = students.getStudentByIndex(index);

        String encodedFile = null;

        URL resource = getClass().getClassLoader().getResource("avatar.jpg");
        InputStream iStream = null;
        try {
            iStream = resource.openStream();
            int resourceSize = resource.openConnection().getContentLength();
            byte[] bytes = new byte[resourceSize];
            iStream.read(bytes);
            encodedFile = Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            return e.toString();
        }
        return encodedFile;
    }
}