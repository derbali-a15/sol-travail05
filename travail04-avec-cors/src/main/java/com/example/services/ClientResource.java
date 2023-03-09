package com.example.services;

import com.example.dao.ClientDAO;
import com.example.entities.Client;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Set;

@Path("clients")
public class ClientResource {
    ClientDAO dao = null;

    public ClientResource() {
        dao = new ClientDAO();
    }

    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    @Path("/banque/{id}")
    public Response trouverClientsParBanque(@PathParam("id") int id){
        Set<Client> clients  =  dao.trouverClientsParBanque(id);
        if(clients == null){
            Response.ResponseBuilder rb = Response.status(404);
            return rb
                    .entity("Banque non trouvée")
                    .header("Content-Type", "text/plain")
                    .build();
        }else{
            Response.ResponseBuilder rb = Response.ok();
            return rb
                    .entity(clients)
                    .header("Content-Type", "application/json")
                    .build();
        }
    }

    @POST
    @Path("/banque/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Client ajouterClientABanque(@PathParam("id") int id, Client client){
        return dao.ajouterClientABanque(id, client);
    }
}
