package com.ceiba.lendings.infraestructura.jpa;

import com.ceiba.lendings.infraestructura.entidades.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentJPA extends JpaRepository<PaymentEntity, Long>{
    List<PaymentEntity> findAll();
}
