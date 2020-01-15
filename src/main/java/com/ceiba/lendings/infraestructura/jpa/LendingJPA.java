package com.ceiba.lendings.infraestructura.jpa;

import com.ceiba.lendings.infraestructura.entidades.LendingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface LendingJPA extends JpaRepository<LendingEntity, Long>{
    List<LendingEntity> findAll();

    @Query(nativeQuery = true,value = "select count(*) from lending where clientid=:clientid")
    Integer getClientLendings(@Param("clientid")Long clientid);
}
