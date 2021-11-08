package com.example.ddd.application.dto;

import com.example.ddd.domain.commande.delete.CommandeDeleteInput;
import com.example.ddd.domain.commande.paiement.CommandePaiementInput;
import org.springframework.beans.BeanUtils;

public class CommandeDto {
    private Long id;
    private String reference;
    private double total;
    private double totalPaye;
    private double montant;

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalPaye() {
        return totalPaye;
    }

    public void setTotalPaye(double totalPaye) {
        this.totalPaye = totalPaye;
    }

    public static CommandePaiementInput toCommandePaiementInput(CommandeDto commandeDto) {
        CommandePaiementInput commandePaiementInput = new CommandePaiementInput();
        if (commandeDto != null)
            BeanUtils.copyProperties(commandeDto, commandePaiementInput);
        return commandePaiementInput;
    }

    public static CommandeDeleteInput toCommandeDeleteInput(CommandeDto commandeDto) {
        CommandeDeleteInput commandeDeleteInput = new CommandeDeleteInput();
        if (commandeDto != null)
            BeanUtils.copyProperties(commandeDto, commandeDeleteInput);
        return commandeDeleteInput;
    }
}


