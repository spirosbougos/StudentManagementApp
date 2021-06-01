package com.example.web.services.restful;

import com.example.services.ejbs.Accounts;
import com.example.services.ejbs.Phones;
import com.example.services.ejbs.Students;
import com.example.services.entities.Account;
import com.example.services.entities.Phone;
import com.example.services.entities.Student;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/Student")
public class StudentController {

    @EJB
    private Students students;


    @POST
    @Path("/createStudent")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student createStudent(Student student) {
        students.add(student);
        return student;
    }

    @DELETE
    @Path("/deleteStudent/{id}")
    public String deleteStudent(@PathParam("id") int id) {
        if(students.delete(id)) {
            return "Student successfully deleted";
        } else {
            return "Can't access student with id: " + id;
        }
    }

    @GET
    @Path("/getStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudents() {
        return students.getAll();
    }

    @GET
    @Path("/gradeOnDemand/{grade}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> gradeOnDemand(@PathParam("grade") double grade) {
        return students.getGrade(grade);
    }

}