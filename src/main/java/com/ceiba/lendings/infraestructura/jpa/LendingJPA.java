package com.ceiba.lendings.infraestructura.jpa;

import com.ceiba.lendings.infraestructura.entidades.LendingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LendingJPA extends JpaRepository<LendingEntity, Long>{
    List<LendingEntity> findAll();
}
