package com.example.dao;

import com.example.entities.Banque;
import com.example.entities.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Set;

public class ClientDAO implements IClientDAO{
    DataManager dataManager = null;
    public ClientDAO() {
        dataManager = DataManager.getSingleInstance();
    }

    @Override
    public Set<Client> trouverClientsParBanque(int id) {
        Banque banque = dataManager.manager.find(Banque.class, id);
        if(banque != null)
            return banque.getClients();
        return null;
    }

    @Override
    public Client ajouterClientABanque(int id, Client client) {
        EntityTransaction transaction = dataManager.manager.getTransaction();
        transaction.begin();
        try{
            Banque banque = dataManager.manager.find(Banque.class, id);
            if(banque != null){
                client.setBanque(banque);
                dataManager.manager.persist(client);
                transaction.commit();
                return client;
            }
        }catch (Exception e){
            transaction.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
}
