package com.ceiba.lendings.infraestructura.jpa;

import com.ceiba.lendings.infraestructura.entidades.LendingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;

public interface LendingJPA extends JpaRepository<LendingEntity, Long>{

    List<LendingEntity> findAll();

    @Modifying
    @Query(nativeQuery = true,value="insert into lending (lending_return_date,lending_total_amount,lending_value,lending_date) values (:lending_return_date,:lending_total_amount,:lending_value,:lending_date)")
    Integer saveLending(@Param("lending_return_date")Date lending_return_date,@Param("lending_total_amount")Integer lending_total_amount,@Param("lending_value")Integer lending_value,@Param("lending_date")Date lending_date);

    @Modifying
    @Query(nativeQuery = true,value="update lending set lending_return_date=:lending_return_date , lending_total_amount=:lending_total_amount where id=:id")
    Integer updateLending(@Param("lending_return_date")Date lending_return_date,@Param("lending_total_amount")Integer lending_total_amount,@Param("id")Integer id);
}
