package com.example.web.services.restful;

import com.example.services.ejbs.Accounts;
import com.example.services.entities.Account;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/Account")
public class AccountController {

    @EJB
    private Accounts accounts;

    @GET
    @Path("/findStudentAccount/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> findAccount(@PathParam("id") int id) {
        return accounts.get(id);
    }

}
