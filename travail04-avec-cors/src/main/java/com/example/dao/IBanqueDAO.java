package com.example.dao;

import com.example.entities.Banque;
import java.util.List;

//contrats
public interface IBanqueDAO {
    List<Banque> trouverBanques();
    Banque ajouterBanque(Banque banque);
    Banque editerBanque(int id, Banque banque);
    Banque supprimerBanque(int id);
}
