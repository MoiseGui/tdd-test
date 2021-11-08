package com.example.ddd.infra.facade;

import com.example.ddd.domain.pojo.Commande;
import com.example.ddd.infra.core.AbstractInfra;
import com.example.ddd.infra.entity.CommandeEntity;

import java.util.List;

public interface CommandeInfra extends AbstractInfra {
    Commande findByReference(String reference);

    int deleteByReference(String reference);

    int save(CommandeEntity commandeEntity);

    int update(CommandeEntity commandeEntity);

    List<CommandeEntity> findAll();

    int update(Commande commande);

}
