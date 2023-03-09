package com.example.services;

import com.example.dao.CompteDAO;
import com.example.entities.Client;
import com.example.entities.Compte;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Set;

@Path("comptes")
public class CompteResource {
    CompteDAO dao = null;

    public CompteResource() {
        dao = new CompteDAO();
    }

    @POST
    @Path("/client/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Compte ajouterCompteAClient(@PathParam("id") int id, Compte compte){
        return dao.ajouterCompteAClient(id, compte);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/client/{id}")
    public Set<Compte> trouverComptesParClient(@PathParam("id") int id){
        return dao.trouverComptesParClient(id);
    }

    @PUT
    @Path("/{id}/{operation}/{montant}")
    @Produces(MediaType.TEXT_PLAIN)
    public String mettreAJourCompte(@PathParam("id")int id, @PathParam("operation")String operation, @PathParam("montant")float montant){
        return dao.mettreAJourCompte(id, operation, montant);
    }
}
