package com.example.web.services.restful;

import com.example.services.ejbs.Phones;
import com.example.services.entities.Phone;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/Phone")
public class PhoneController {

    @EJB
    private Phones phones;

    @GET
    @Path("/getStudentPhone/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Phone> getStudentPhone(@PathParam("id") int id) {
        return phones.getPhone(id);
    }

    @GET
    @Path("/getPhones")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Phone> getAllPhones() {
        return phones.getPhones();
    }

    @POST
    @Path("/addPhone")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Phone addStudentPhone(Phone phone) {
        return phones.addPhone(phone);
    }
}
