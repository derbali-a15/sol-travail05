package com.example.dao;

import com.example.entities.Banque;
import com.example.entities.Client;
import com.example.entities.Compte;
import jakarta.persistence.EntityTransaction;

import java.util.Set;

public class CompteDAO implements ICompteDAO{

    public static final String RETRAIT = "retrait";
    public static final String DEPOT = "depot";
    DataManager dataManager = null;
    public CompteDAO() {
        dataManager = DataManager.getSingleInstance();
    }

    @Override
    public Compte ajouterCompteAClient(int id, Compte compte) {
        EntityTransaction transaction = dataManager.manager.getTransaction();
        transaction.begin();
        try{
            Client client = dataManager.manager.find(Client.class, id);
            if(client != null){
                compte.setClient(client);
                dataManager.manager.persist(compte);
                transaction.commit();
                return compte;
            }
        }catch (Exception e){
            transaction.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Set<Compte> trouverComptesParClient(int id) {
        Client client = dataManager.manager.find(Client.class, id);
        if(client !=null){
            return client.getComptes();
        }
        return null;
    }

    @Override
    public String mettreAJourCompte(int id, String operation, float montant) {
        Compte compte = dataManager.manager.find(Compte.class, id);
        if(compte == null){
            return "Attention compte numero  " + id + " inexistant !";
        }
        //compte existant
        if(operation.toLowerCase().equals(RETRAIT)){
            if(compte.getSolde() < montant){
                return "Attention montant insuffisant lors du retrait !";
            }
            //montant est suffisant
            EntityTransaction transaction = dataManager.manager.getTransaction();
            transaction.begin();
            try{
                compte.setSolde(compte.getSolde() - montant);
                transaction.commit();
                return "Opération de retrait est effectuée";
            }catch (Exception e){
                transaction.rollback();
                System.out.println(e.getMessage());
            }
        }else if(operation.toLowerCase().equals(DEPOT)){
            EntityTransaction transaction = dataManager.manager.getTransaction();
            transaction.begin();
            try{
                compte.setSolde(compte.getSolde() + montant);
                transaction.commit();
                return "Opération de dépôt est effectuée";
            }catch (Exception e){
                transaction.rollback();
                System.out.println(e.getMessage());
            }
        }
        return "Attention opération non effectuée ou non reconnue !";
    }
}
