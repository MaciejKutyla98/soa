package pl.edu.agh.soa.lab;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pl.edu.agh.dao.StudentDao;
import pl.edu.agh.soa.model.ListOfStudents;
import pl.edu.agh.soa.model.Student;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Path("/")
@Api( value = "Student Controller")
public class StudentController {

    //@Inject
    private ListOfStudents students = new ListOfStudents();

    @Inject
    private StudentDao studentDao = new StudentDao();

    //Zad3

    @GET
    @Path("/zad3/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "[JPA] Returns a student with given index number",
            response = Student.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No student with given index number found"),
            @ApiResponse(code = 500, message = "Student record broken"),
            @ApiResponse(code = 200, message = "Student found", response = Student.class)
    })

    public Response daoGetStudentByIdx(@PathParam("id") int idx){
        Student result = studentDao.finder(idx);
        return  Response.status(Response.Status.OK).entity(result).build();
    }

    @POST
    @Path("/zad3/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @TokenNeeded
    @ApiOperation(
            value = "[JPA] Adds and returns a student.",
            notes = "You must provide authentication token. See 'Authentication Controller' documentation",
            response = Student.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 409, message = "Student already exists in the DB"),
            @ApiResponse(code = 200, message = "Student added successfully. Returns added student.",
                    response = Student.class)
    })
    public Response daoAddStudent(Student student) {
        try {
            studentDao.save(student);
            return Response.status(Response.Status.OK).entity(student).build();
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).
                    entity("Error - this student already exists in the DB").build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/zad3/delete/{id}")
    @TokenNeeded
    @ApiOperation(
            value = "[JPA] Deletes a student.",
            notes = "You must provide authentication token. See 'Authentication Controller' documentation",
            response = String.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Student doesn't exist in the DB."),
            @ApiResponse(code = 200, message = "Student deleted successfully.")
    })
    public Response daoDeleteStudent(@PathParam("id") int idx) {
        studentDao.remove(idx);
        String entity = "Student " + idx + " deleted successfully.";
        return Response.status(Response.Status.OK).entity(entity).build();
    }


    //Zad2

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Returns a student with given index number",
            response = Student.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No student found"),
            @ApiResponse(code = 200, message = "Student found", response = Student.class)
    })

    public Response getStudentByIndex(@PathParam("id") int idx) {
        Student result = students.getStudentByIndex(idx);
        if(result == null)
            return Response.status(Response.Status.NOT_FOUND).
                    entity("Error - student doesn't exist").build();
        return Response.status(Response.Status.OK).entity(result).build();
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Returns all students",
            response = Student.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No studentsfound"),
            @ApiResponse(code = 200, message = "Students found",
                    response = Student.class,
                    responseContainer = "List"
            )
    })
    public Response getAllStudents(
            @QueryParam("firstName") String name,
            @QueryParam("age") int age
    ) {

        List<Student> result = students.getStudents();
        if(name != null)
            result = result.stream().filter(student -> student.getName().equals(name)).
                    collect(Collectors.toList());
        if(age != 0)
            result = result.stream().filter(student -> student.getAge() == age).
                    collect(Collectors.toList());
        if(result == null || result.size() == 0)
            return Response.status(Response.Status.NOT_FOUND).entity("No students found").build();
        return Response.status(Response.Status.OK).entity(result).build();
    }

    @GET
    @Path("/getAvatar/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @ApiOperation(
            value = "Gets base64 encoded avatar of the student.",
            response = byte.class,
            responseContainer = "Array"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Student doesn't exist "),
            @ApiResponse(code = 500, message = "A server error has occured while retrieving encoded avatar."),
            @ApiResponse(code = 200, message = "Returns student's encoded avatar.")
    })
    public Response getBase64Avatar(@PathParam("id") int index) {
        Student student = students.getStudentByIndex(index);
        if(student ==  null)
            return Response.status(Response.Status.NOT_FOUND).entity("Student doesn't exist").build();
        String encodedFile = null;

        URL resource = getClass().getClassLoader().getResource(student.getAvatar());
        InputStream iStream = null;
        try {
            iStream = resource.openStream();
            int resourceSize = resource.openConnection().getContentLength();
            byte[] bytes = new byte[resourceSize];
            iStream.read(bytes);
            encodedFile = Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.toString()).build();
        }
        return Response.status(Response.Status.OK).entity(encodedFile).build();
    }
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @TokenNeeded
    public Response addStudent(Student student) {
        if(students.getStudentByIndex(student.getIndex()) == null) {
            students.addStudent(student);
            return Response.status(Response.Status.OK).entity(student).build();
        }
        return Response.status(Response.Status.CONFLICT).
                entity("Error - this student already exists ").build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    @TokenNeeded
    @ApiOperation(
            value = "Deletes a student.",
            notes = "You must provide authentication token. See 'Authentication Controller' documentation",
            response = String.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Student doesn't exist."),
            @ApiResponse(code = 200, message = "Student deleted successfully.")
    })
    public Response deleteStudentByIndeX(@PathParam("id") int idxex) {
        boolean deletion = students.deleteStudentByIndeX(idxex);
        if(deletion) {
            String entity = "Student " + idxex + " deleted successfully.";
            return Response.status(Response.Status.OK).entity(entity).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Student doesn't exist.").build();
    }

    @PUT
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @TokenNeeded
    @ApiOperation(
            value = "Edits and returns a student.",
            response = Student.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Student doesn't exist."),
            @ApiResponse(code = 200, message = "Student edited successfully.",
                    response = Student.class)
    })
    public Response editStudent(Student student) {
        Student studentToEdit = students.getStudentByIndex(student.getIndex());
        if(studentToEdit == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Student doesn't exist.").build();
        }
        studentToEdit.setName(student.getName());
        studentToEdit.setAge(student.getAge());
        return Response.status(Response.Status.OK).entity(studentToEdit).build();
    }


}
