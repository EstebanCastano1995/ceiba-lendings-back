package com.ceiba.lendings.infraestructura.jpa;

import com.ceiba.lendings.infraestructura.entidades.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface ClientJPA extends JpaRepository<ClientEntity, Long> {

    List<ClientEntity> findAll();

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value="insert into client (id,name,address,phone,birth_date) values (:id,:name,:address,:phone,:birth_date)")
    Integer saveClient(@Param("id")Integer id,@Param("name")String name,@Param("address")String address,@Param("phone")String phone,@Param("birth_date") Date birth_date);

    @Transactional
    @Modifying
    @Query("delete from ClientEntity where id = :id")
    Integer deleteClient(@Param("id")String id);
}