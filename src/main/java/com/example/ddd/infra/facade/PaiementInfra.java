package com.example.ddd.infra.facade;

import com.example.ddd.domain.pojo.Paiement;
import com.example.ddd.infra.core.AbstractInfra;

public interface PaiementInfra extends AbstractInfra {
    Paiement findByReference(String reference);

    int deleteByReference(String reference);

    int save(Paiement paiement);


}
