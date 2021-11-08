package com.example.ddd.application.util;

import com.example.ddd.domain.commande.delete.CommandeDeleteProcess;
import com.example.ddd.domain.commande.delete.CommandeDeleteProcessImpl;
import com.example.ddd.domain.commande.paiement.CommandePaiementProcess;
import com.example.ddd.domain.commande.paiement.CommandePaiementProcessImpl;
import com.example.ddd.domain.paiement.PaiementCreateProcess;
import com.example.ddd.domain.paiement.PaiementCreateProcessImpl;
import com.example.ddd.infra.facade.CommandeInfra;
import com.example.ddd.infra.facade.PaiementInfra;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Processinjection {

    @Bean
    public  CommandePaiementProcess commandePaiementProcess(CommandeInfra commandeInfra){
        return new CommandePaiementProcessImpl(commandeInfra);
    }
    @Bean
    public CommandeDeleteProcess commandeDeleteProcess(CommandeInfra commandeInfra){
        return new CommandeDeleteProcessImpl(commandeInfra);
    }

    @Bean
    public PaiementCreateProcess paiementCreateProcess(CommandeInfra commandeInfra, PaiementInfra paiementInfra){
        return new PaiementCreateProcessImpl(paiementInfra,commandeInfra);
    }
}

