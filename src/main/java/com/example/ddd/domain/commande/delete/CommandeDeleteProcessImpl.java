package com.example.ddd.domain.commande.delete;

import com.example.ddd.domain.core.AbstractProcessImpl;
import com.example.ddd.domain.pojo.Commande;
import com.example.ddd.domain.core.Result;
import com.example.ddd.infra.facade.CommandeInfra;

public class CommandeDeleteProcessImpl extends AbstractProcessImpl<CommandeDeleteInput> implements  CommandeDeleteProcess {


    public void validate(CommandeDeleteInput commandeDeleteInput, Result result){
        String reference=commandeDeleteInput.getReference();
        Commande commande = commandeInfra.findByReference(reference);
        if(commande==null || commande.getId()==null){
            result.addErrorMessage(commandeInfra.getMessage("commande.delete.not_founded"));
        }
        if(commande.getTotalPaye() != 0){
            result.addErrorMessage(commandeInfra.getMessage("commande.delete.prob_montant"));
        }
    }


    public void run(CommandeDeleteInput commandeDeleteInput, Result result) {
        String reference=commandeDeleteInput.getReference();
        commandeInfra.deleteByReference(reference);
        result.addInfoMessage(commandeInfra.getMessage("commande.delete.delted_sucess"));
        result.setStatus(1);
    }

    public CommandeDeleteProcessImpl(CommandeInfra commandeInfra){
        this.commandeInfra = commandeInfra;
    }


    private CommandeInfra commandeInfra;
}
