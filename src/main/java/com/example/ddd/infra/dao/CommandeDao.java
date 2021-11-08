package com.example.ddd.infra.dao;

import com.example.ddd.infra.entity.CommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeDao extends JpaRepository<CommandeEntity,Long> {
    CommandeEntity findByReference(String reference);
    int deleteByReference(String reference);
}
