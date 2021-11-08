package com.example.ddd.domain.paiement;

import com.example.ddd.domain.core.AbstractProcessInput;
import com.example.ddd.domain.pojo.Paiement;

public class PaiementCreateProcessInput extends AbstractProcessInput {
    private String referenceCommande;
    private Paiement   paiement;

    public String getReferenceCommande() {
        return referenceCommande;
    }

    public void setReferenceCommande(String referenceCommande) {
        this.referenceCommande = referenceCommande;
    }

    public Paiement getPaiement() {
        if (paiement == null) {
            paiement= new Paiement();
        }
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }
}
