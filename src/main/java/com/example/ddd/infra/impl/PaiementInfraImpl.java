package com.example.ddd.infra.impl;

import com.example.ddd.domain.pojo.Commande;
import com.example.ddd.domain.pojo.Paiement;
import com.example.ddd.infra.core.AbstractInfraImpl;
import com.example.ddd.infra.dao.CommandeDao;
import com.example.ddd.infra.dao.PaiementDao;
import com.example.ddd.infra.entity.CommandeEntity;
import com.example.ddd.infra.entity.PaiementEntity;
import com.example.ddd.infra.facade.CommandeInfra;
import com.example.ddd.infra.facade.PaiementInfra;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PaiementInfraImpl extends AbstractInfraImpl implements PaiementInfra {

    @Override
    public Paiement findByReference(String reference) {
        PaiementEntity paiementEntity = paiementDao.findByReference(reference);
        Paiement paiement = new Paiement();
        if (paiementEntity != null) {
            BeanUtils.copyProperties(paiementEntity, paiement);
        }
        return paiement;
    }

    @Override
    public int deleteByReference(String reference) {
        return paiementDao.deleteByReference(reference);
    }

    @Override
    public int save(Paiement paiement) {
            PaiementEntity paiementEntity = new PaiementEntity();
            BeanUtils.copyProperties(paiement, paiementEntity);
            if( paiement.getCommande()!=null && paiement.getCommande().getId()!=null){
                paiementEntity.setCommande(new CommandeEntity());
            }
            paiementEntity.getCommande().setId(paiement.getCommande().getId());
            paiementDao.save(paiementEntity);
            return 1;
    }


    @Autowired
    private PaiementDao paiementDao;
}
