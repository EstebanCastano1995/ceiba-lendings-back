package com.ceiba.lendings.infraestructura.adaptador.repositorio.payment;

import com.ceiba.lendings.dominio.entidades.Payment;
import com.ceiba.lendings.dominio.repositorio.payment.PaymentRepository;
import com.ceiba.lendings.infraestructura.entidades.PaymentEntity;
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
        paymentJPA.save(paymentEntity);
        return true;
    }

    private Boolean translateResult(Integer result) {
        return result>0?true:false;
    }
}
