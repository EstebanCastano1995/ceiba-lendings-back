package com.ceiba.lendings.servicio;

import com.ceiba.lendings.BaseTest;
import com.ceiba.lendings.databuilder.LendingTestDataBuilder;
import com.ceiba.lendings.dominio.entidades.Lending;
import com.ceiba.lendings.dominio.repositorio.lending.LendingRepository;
import com.ceiba.lendings.dominio.servicio.lending.LendingServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ManageLendingServiceTest {

    @Test
    public void validateCreateLending() {
        Lending lending=new LendingTestDataBuilder().build();
        LendingRepository lendingRepository = Mockito.mock(LendingRepository.class);
        Mockito.when(lendingRepository.createLending(Mockito.any())).thenReturn(true);

        LendingServiceImpl lendingService = new LendingServiceImpl(lendingRepository);
        BaseTest.assertCorrect(lendingService.createLending(lending), true);
    }
}
