package com.example.ddd.infra.impl;

import com.example.ddd.domain.pojo.Commande;
import com.example.ddd.infra.core.AbstractInfraImpl;
import com.example.ddd.infra.dao.CommandeDao;
import com.example.ddd.infra.entity.CommandeEntity;
import com.example.ddd.infra.facade.CommandeInfra;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CommandeInfraImpl extends AbstractInfraImpl implements CommandeInfra {

    @Override
    public Commande findByReference(String reference) {
        CommandeEntity commandeEntity = commandeDao.findByReference(reference);
        Commande commande= new Commande();
        if(commandeEntity!=null){
            BeanUtils.copyProperties(commandeEntity,commande);
        }
        return commande;
    }

    @Override
    @Transactional
    public int deleteByReference(String reference) {
        return commandeDao.deleteByReference(reference);
    }

    @Override
    public int save(CommandeEntity commandeEntity) {
        if (findByReference(commandeEntity.getReference()) != null)
            return -1;
        commandeDao.save(commandeEntity);
        return 1;
    }

    @Override
    public int update(CommandeEntity commandeEntity) {
        if (findByReference(commandeEntity.getReference()) == null)
            return -1;
        commandeDao.save(commandeEntity);
        return 1;
    }
    @Override
    public int update(Commande commande) {
        CommandeEntity commandeEntity = new CommandeEntity();
        BeanUtils.copyProperties(commande,commandeEntity);
        return update(commandeEntity);
    }

    @Override
    public List<CommandeEntity> findAll() {
        return commandeDao.findAll();
    }

    @Autowired
    private CommandeDao commandeDao;
}
