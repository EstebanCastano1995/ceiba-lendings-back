package com.ceiba.lendings.infraestructura.jpa;

import com.ceiba.lendings.infraestructura.entidades.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface PaymentJPA extends JpaRepository<PaymentEntity, Long>{
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value="insert into payment (payment_value,payment_date) values (:payment_value,:payment_date)")
    Integer savePayment(@Param("payment_value")Integer payment_value,@Param("payment_date") Date payment_date);
}
