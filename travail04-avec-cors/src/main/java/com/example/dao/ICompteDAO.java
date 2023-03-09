package com.example.dao;

import com.example.entities.Compte;

import java.util.Set;

public interface ICompteDAO {
    Compte ajouterCompteAClient(int id, Compte compte); //id du client
    Set<Compte> trouverComptesParClient(int id); //id du client
    String mettreAJourCompte(int id, String operation,float montant); //id du compte

}
