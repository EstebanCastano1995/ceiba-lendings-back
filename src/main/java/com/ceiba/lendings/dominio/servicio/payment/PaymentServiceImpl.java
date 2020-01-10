package com.ceiba.lendings.dominio.servicio.payment;

import com.ceiba.lendings.aplicacion.services.PaymentService;
import com.ceiba.lendings.dominio.entidades.Payment;
import com.ceiba.lendings.dominio.repositorio.lending.LendingRepository;
import com.ceiba.lendings.dominio.repositorio.payment.PaymentRepository;
import org.springframework.stereotype.Service;
import javax.inject.Inject;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Inject
    private PaymentRepository paymentRepository;

    @Override
    public Boolean createPayment(Payment payment) {
        return paymentRepository.createPayment(payment);
    }
}
