package com.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//une classe singleton
public class DataManager {
    private static DataManager singleInstance = null;
    public EntityManager manager = null;
    private DataManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("bank_system");
        this.manager = factory.createEntityManager();
    }

    public static DataManager getSingleInstance(){
        if(singleInstance == null){
            singleInstance = new DataManager();
        }
        return singleInstance;
    }
}
