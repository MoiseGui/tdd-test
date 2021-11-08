package com.example.ddd.application.dto;

import com.example.ddd.domain.commande.paiement.CommandePaiementInput;
import com.example.ddd.domain.paiement.PaiementCreateProcessInput;
import com.example.ddd.domain.pojo.Paiement;
import org.springframework.beans.BeanUtils;

public class PaiementDto {

    private Long id;
    private String reference;
    private double montant;
    private CommandeDto commande;

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

    public CommandeDto getCommande() {
        return commande;
    }

    public void setCommande(CommandeDto commande) {
        this.commande = commande;
    }

    public static PaiementCreateProcessInput to(PaiementDto paiementDto) {
        PaiementCreateProcessInput paiementCreateProcessInput = new PaiementCreateProcessInput();
        BeanUtils.copyProperties(paiementDto, paiementCreateProcessInput.getPaiement());
        paiementCreateProcessInput.setReferenceCommande(paiementDto.getCommande().getReference());
        return paiementCreateProcessInput;
    }
}
