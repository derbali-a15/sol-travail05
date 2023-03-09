package com.example.services;

import com.example.dao.BanqueDAO;
import com.example.entities.Banque;
import com.example.entities.Client;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/banques")
public class BanqueResource {
    BanqueDAO dao = null;
    public BanqueResource() {
        this.dao = new BanqueDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Banque> trouverBanques(){
        return dao.trouverBanques();
    }


    @Path("v2")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response trouverBanquesV2(){
        Response.ResponseBuilder rb = Response.ok(dao.trouverBanques());
        return rb.build() ;
    }

    @Path("v2")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ajouterBanquesV2(Banque banque){
        Response.ResponseBuilder rb = Response.ok(dao.ajouterBanque(banque));
        return rb.build() ;
    }

    @Path("v2/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editerBanquesV2(@PathParam("id") int id, Banque banque){
        Response.ResponseBuilder rb = Response.ok(dao.editerBanque(id,banque));
        return rb.build() ;
    }

    @Path("v2/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response editerBanquesV2(@PathParam("id") int id){
        Response.ResponseBuilder rb = Response.ok(dao.supprimerBanque(id));
        return rb.build() ;
    }
}
