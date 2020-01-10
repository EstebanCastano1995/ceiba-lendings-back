package com.ceiba.lendings.infraestructura.adaptador.repositorio.payment;

import com.ceiba.lendings.dominio.entidades.Payment;
import com.ceiba.lendings.dominio.repositorio.payment.PaymentRepository;
import com.ceiba.lendings.infraestructura.entidades.LendingEntity;
import com.ceiba.lendings.infraestructura.entidades.PaymentEntity;
import com.ceiba.lendings.infraestructura.jpa.LendingJPA;
import com.ceiba.lendings.infraestructura.jpa.PaymentJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.modelmapper.ModelMapper;

@Repository
public class PaymentRepositoryJpa implements PaymentRepository {

    @Autowired
    private PaymentJPA paymentJPA;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Boolean createPayment(Payment payment) {
        PaymentEntity paymentEntity = modelMapper.map(payment, PaymentEntity.class);
        return this.translateResult(paymentJPA.savePayment(paymentEntity.getPayment_value(),paymentEntity.getPayment_date()));
    }

    private Boolean translateResult(Integer result) {
        return result>1?true:false;
    }
}
