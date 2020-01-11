package com.ceiba.lendings.infraestructura.jpa;

import com.ceiba.lendings.infraestructura.entidades.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClientJPA extends JpaRepository<ClientEntity, Long> {
    List<ClientEntity> findAll();
}