package com.example.ddd.infra.dao;

import com.example.ddd.infra.entity.PaiementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementDao extends JpaRepository<PaiementEntity, Long> {
    PaiementEntity findByReference(String reference);

    int deleteByReference(String reference);
}
