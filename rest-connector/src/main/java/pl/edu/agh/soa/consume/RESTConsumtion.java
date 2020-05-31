package pl.edu.agh.soa.consume;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import pl.edu.agh.soa.model.Student;

import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.Base64;
import java.util.List;

public class RESTConsumtion {

    private static final String URL = "http://localhost:8080/rest-api/students/";
    private  String username, password;
    private ResteasyClient resteasyClient;
    private static String token = null;

    public static void main(String[] args) {

        RESTConsumtion consumer = new RESTConsumtion("adminadmin","passwordpassword");

        // Get all
      for(Student st : consumer.getAllStudents(null)) {           System.out.println(st.toString());       }

        // Get one
        Student student = consumer.getStudent(297242);
        if(student != null) {
            System.out.println(student.toString());
        }

        // Get Avatar
        byte[] avatar = consumer.getAvatar(297242);
        if(avatar != null)
            System.out.println("Avatar byte array size: " + avatar.length);

        //Add
        Student nStudent = new Student(297244, "Maciej Kozak", 19);
        System.out.println(consumer.addStudent(nStudent));


        // Edit
        if(student != null) {
            student.setName("Jacek");
            System.out.println(consumer.editStudent(student));
        }

        // Delete
        System.out.println(consumer.deleteStudent(297225));

        // Get all
        for(Student st : consumer.getAllStudents(null)) {
            System.out.println(st.toString());
        }

        consumer.finishSession();
    }

    public RESTConsumtion() {
        this.resteasyClient = new ResteasyClientBuilder().build();
    }

    public RESTConsumtion(String username, String password) {
        this.resteasyClient = new ResteasyClientBuilder().build();
        this.username = username;
        this.password = password;
    }

    private Student getStudent(int index) {
        Student result = null;

        System.out.println("GETTING STUDENT " + index + ':');

        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/rest-api/students/" + "get/" + index);
        Response response = target.request().get();
        int responseStatus = response.getStatus();

        if (responseStatus == 200)
            result = response.readEntity(Student.class);
        response.close();

        System.out.println("RESPONSE STATUS: "+responseStatus);
        return result;
    }

    public byte[] getAvatar(int index) {
        byte[] result = null;

        System.out.println("GETTING STUDENT " + index + " AVATAR:");

        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/rest-api/students/" + "getAvatar/" + index);
        Response response = target.request().get();
        int responseStatus = response.getStatus();

        if(responseStatus == 200) {
            String encodedAvatar = response.readEntity(String.class);
            result = Base64.getDecoder().decode(encodedAvatar);
        }
        response.close();

        System.out.println("RESPONSE STATUS: "+responseStatus);
        return result;
    }

    private List<Student> getAllStudents(MultivaluedMap<String, Object> parameters) {
        List<Student> result = null;

        System.out.print("GETTING STUDENTS");

        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/rest-api/students/" + "getAll");
        if(parameters != null && !parameters.isEmpty()) {
            target = target.queryParams(parameters);
            for(String key : parameters.keySet()) {
                System.out.println(" - " + key + ": " + parameters.getFirst(key));
            }
        }
        else {
            System.out.println(':');
        }
        Response response = target.request().get();
        int responseStatus = response.getStatus();
        if(responseStatus == 200) {
            result = response.readEntity(new GenericType<List<Student>>() {});
        }
        response.close();

        System.out.println("RESPONSE STATUS: "+responseStatus);
        return result;
    }

    public void authorize() {
        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/rest-api/students/auth")
                .queryParam("username", username)
                .queryParam("password", password);
        Response response = target.request().get();
        token = response.readEntity(String.class);

        resteasyClient.register((ClientRequestFilter) clientRequestContext ->
                clientRequestContext.getHeaders().add("Authorization", "Bearer " + token));
    }

    public Student addStudent(Student student) {
        Student result = null;

        System.out.println("ADDING STUDENT " + student.getIndex() + ':');

        if(token == null) {
            authorize();
        }
        System.out.println(student.getIndex());
        System.out.println(student.getAge());
        System.out.println(student.getName());
        System.out.println(token);

        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/rest-api/students/add");
        Response response = target.request().post(Entity.entity(student, MediaType.APPLICATION_JSON_TYPE));
        int responseStatus = response.getStatus();
        if(responseStatus == 200) {
            result = response.readEntity(Student.class);
        }
        response.close();

        System.out.println("RESPONSE STATUS: "+ responseStatus);
        return result;
    }

    public String deleteStudent(int index) {
        System.out.println("DELETING STUDENT " + index + ':');

        if(token == null) {
            authorize();
        }

        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/rest-api/students/" + "delete/" + index);
        Response response = target.request().delete();
        int responseStatus = response.getStatus();

        String result = response.readEntity(String.class);
        response.close();

        System.out.println("RESPONSE STATUS: "+responseStatus);
        return result;
    }

    public Student editStudent(Student student) {
        Student result = null;

        System.out.println("EDITING STUDENT " + student.getIndex() + ':');

        if(token == null) {
            authorize();
        }

        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/rest-api/students/" + "edit");
        Response response = target.request().put(Entity.entity(student, MediaType.APPLICATION_JSON_TYPE));
        int responseStatus = response.getStatus();

        if(responseStatus == 200) {
            result = response.readEntity(Student.class);
        }
        response.close();

        System.out.println("RESPONSE STATUS: "+responseStatus);
        return result;
    }

    public void finishSession() {
        if(!resteasyClient.isClosed())
            resteasyClient.close();
    }
}
