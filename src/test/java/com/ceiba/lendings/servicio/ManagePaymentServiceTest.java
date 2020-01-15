package com.ceiba.lendings.servicio;

import com.ceiba.lendings.BaseTest;
import com.ceiba.lendings.databuilder.PaymentTestDataBuilder;
import com.ceiba.lendings.dominio.entidades.Payment;
import com.ceiba.lendings.dominio.excepcion.LendingClientMustExistException;
import com.ceiba.lendings.dominio.excepcion.LendingMustBeCreatedException;
import com.ceiba.lendings.dominio.repositorio.payment.PaymentRepository;
import com.ceiba.lendings.dominio.servicio.payment.CreatePaymentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ManagePaymentServiceTest {

    @Test
    public void validateCreatePayment() {
        Payment payment=new PaymentTestDataBuilder().build();
        PaymentRepository paymentRepository = Mockito.mock(PaymentRepository.class);
        Mockito.when(paymentRepository.checkIfLendingExist(Mockito.any())).thenReturn(false);

        CreatePaymentService paymentService = new CreatePaymentService(paymentRepository);
        BaseTest.assertThrows(()-> paymentService.createPayment(payment), LendingMustBeCreatedException.class, "El pago que desea registrar no tiene un prestamo asociado registrado");
    }
}
