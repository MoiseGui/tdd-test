package com.example.ddd.infra.entity;

import javax.persistence.*;

@Entity
public class PaiementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private double montant;
    @ManyToOne
    private CommandeEntity commande;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public CommandeEntity getCommande() {
        return commande;
    }

    public void setCommande(CommandeEntity commande) {
        this.commande = commande;
    }
}
