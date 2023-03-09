package com.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nomDeFamille")
    private String nomDeFamille;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "telephone")
    private String telephone;

    @ManyToOne
    @JoinColumn(name = "banqueId", referencedColumnName = "id")
    //@JsonIgnore
    private Banque banque;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private Set<Compte> comptes;

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }

    public Client() {
    }

    public Client(int id, String nomDeFamille, String prenom, String telephone) {
        this.id = id;
        this.nomDeFamille = nomDeFamille;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomDeFamille() {
        return nomDeFamille;
    }

    public void setNomDeFamille(String nomDeFamille) {
        this.nomDeFamille = nomDeFamille;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nomDeFamille='" + nomDeFamille + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", banque=" + banque +
                '}';
    }
}
