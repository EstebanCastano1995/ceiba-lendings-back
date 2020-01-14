package com.ceiba.lendings.servicio;

import com.ceiba.lendings.BaseTest;
import com.ceiba.lendings.databuilder.PaymentTestDataBuilder;
import com.ceiba.lendings.dominio.entidades.Payment;
import com.ceiba.lendings.dominio.repositorio.payment.PaymentRepository;
import com.ceiba.lendings.dominio.servicio.payment.PaymentServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ManagePaymentServiceTest {

    @Test
    public void validateCreatePayment() {
        Payment payment=new PaymentTestDataBuilder().build();
        PaymentRepository paymentRepository = Mockito.mock(PaymentRepository.class);
        Mockito.when(paymentRepository.createPayment(Mockito.any())).thenReturn(true);

        PaymentServiceImpl paymentService = new PaymentServiceImpl(paymentRepository);
        BaseTest.assertCorrect(paymentService.createPayment(payment), true);
    }

}
