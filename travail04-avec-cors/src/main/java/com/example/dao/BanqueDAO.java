package com.example.dao;

import com.example.entities.Banque;
import com.example.entities.Client;
import jakarta.persistence.*;

import java.util.List;

public class BanqueDAO implements IBanqueDAO {
    DataManager dataManager = null;
    public BanqueDAO() {
        dataManager = DataManager.getSingleInstance();
    }

    @Override
    public List<Banque> trouverBanques() {
        if(dataManager.manager != null){
            Query query = dataManager.manager.createQuery("SELECT b FROM Banque  b");
            return query.getResultList();
        }
        return null;
    }

    @Override
    public Banque ajouterBanque(Banque banque) {
        EntityTransaction transaction = dataManager.manager.getTransaction();
        transaction.begin();
        try{
            if(banque != null){
                dataManager.manager.persist(banque);
                transaction.commit();
                return banque;
            }
        }catch (Exception e){
            transaction.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Banque editerBanque(int id, Banque banque) {
        EntityTransaction transaction = dataManager.manager.getTransaction();
        transaction.begin();
        try{
            Banque existBanque = dataManager.manager.find(Banque.class, id);
            if(existBanque != null){
                existBanque.setNom(banque.getNom());
                existBanque.setVille(banque.getVille());
                transaction.commit();
                return existBanque;
            }
        }catch (Exception e){
            transaction.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Banque supprimerBanque(int id) {
        EntityTransaction transaction = dataManager.manager.getTransaction();
        transaction.begin();
        try{
            Banque existBanque = dataManager.manager.find(Banque.class, id);
            if(existBanque != null){
                dataManager.manager.remove(existBanque);
                transaction.commit();
                return existBanque;
            }
        }catch (Exception e){
            transaction.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
}
