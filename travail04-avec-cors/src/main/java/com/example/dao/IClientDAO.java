package com.example.dao;

import com.example.entities.Client;

import java.util.Set;

public interface IClientDAO {
    Set<Client> trouverClientsParBanque(int id); //id de la banque
    Client ajouterClientABanque(int id, Client client); //id de la banque
}
