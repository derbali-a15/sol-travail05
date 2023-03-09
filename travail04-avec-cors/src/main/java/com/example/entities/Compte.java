package com.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "solde")
    private float solde;

    @ManyToOne
    @JoinColumn(name = "clientId", referencedColumnName = "id")
    private Client client;

    public Compte() {
    }

    public Compte(int id, String type, float solde) {
        this.id = id;
        this.type = type;
        this.solde = solde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", solde=" + solde +
                ", client=" + client +
                '}';
    }
}
