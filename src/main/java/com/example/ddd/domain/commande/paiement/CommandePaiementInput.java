package com.example.ddd.domain.commande.paiement;

import com.example.ddd.domain.core.AbstractProcessInput;

public class CommandePaiementInput extends AbstractProcessInput {
    String reference;
    double montant;

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
}
