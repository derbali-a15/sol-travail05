package com.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Banque")
public class Banque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "ville")
    private String ville;

    @OneToMany(mappedBy = "banque")
    @JsonIgnore
    private Set<Client> clients;

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Banque() {
    }

    public Banque(String nom, String ville) {
        this.nom = nom;
        this.ville = ville;
    }

    public Banque(int id, String nom, String ville) {
        this.id = id;
        this.nom = nom;
        this.ville = ville;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Banque{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
