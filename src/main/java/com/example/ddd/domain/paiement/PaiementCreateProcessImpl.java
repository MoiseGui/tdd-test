package com.example.ddd.domain.paiement;

import com.example.ddd.domain.core.AbstractProcessImpl;
import com.example.ddd.domain.core.Result;
import com.example.ddd.domain.pojo.Commande;
import com.example.ddd.domain.pojo.Paiement;
import com.example.ddd.infra.facade.CommandeInfra;
import com.example.ddd.infra.facade.PaiementInfra;

public class PaiementCreateProcessImpl extends AbstractProcessImpl<PaiementCreateProcessInput> implements PaiementCreateProcess {


    @Override
    public void validate(PaiementCreateProcessInput abstractProcessInput, Result result) {
        Commande commande = commandeInfra.findByReference(abstractProcessInput.getReferenceCommande());
        Paiement paiement = paiementInfra.findByReference(abstractProcessInput.getPaiement().getReference());
        if (commande == null) {
            result.addErrorMessage("paiement.create.commande_not_founded");
        }else if(commande.getTotalPaye()+abstractProcessInput.getPaiement().getMontant()>commande.getTotal()){
            result.addErrorMessage("paiement.create.montant_invalid");
        }
        if (paiement != null && paiement.getId() != null) {
            result.addErrorMessage("paiement.create.paiement_already_exists");
        }
    }

    @Override
    public void run(PaiementCreateProcessInput abstractProcessInput, Result result) {
        Commande commande = commandeInfra.findByReference(abstractProcessInput.getReferenceCommande());
        Paiement paiement = abstractProcessInput.getPaiement();
        paiement.setCommande(commande);
        commande.setTotalPaye(commande.getTotalPaye()+paiement.getMontant());
        commandeInfra.update(commande);
        paiementInfra.save(paiement);
        result.addInfoMessage("paiement.create.paiement_created");
    }

    public PaiementCreateProcessImpl(PaiementInfra paiementInfra, CommandeInfra commandeInfra) {
        this.paiementInfra = paiementInfra;
        this.commandeInfra = commandeInfra;
    }


    private PaiementInfra paiementInfra;
    private CommandeInfra commandeInfra;
}
