package com.ceiba.lendings.infraestructura.adaptador.repositorio.payment;

import com.ceiba.lendings.dominio.entidades.Payment;
import com.ceiba.lendings.dominio.repositorio.payment.PaymentRepository;
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

    @Autowired
    private LendingJPA lendingJPA;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public void createPayment(Payment payment) {
        PaymentEntity paymentEntity = modelMapper.map(payment, PaymentEntity.class);
        paymentJPA.save(paymentEntity);
    }

    @Override
    public Boolean checkIfLendingExist(Payment payment) {
        PaymentEntity paymentEntity = modelMapper.map(payment, PaymentEntity.class);
        return lendingJPA.existsById(paymentEntity.getLendingid().getId());
    }
}
