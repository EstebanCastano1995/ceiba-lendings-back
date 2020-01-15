package com.ceiba.lendings.servicio;

import com.ceiba.lendings.BaseTest;
import com.ceiba.lendings.databuilder.LendingTestDataBuilder;
import com.ceiba.lendings.dominio.entidades.Lending;
import com.ceiba.lendings.dominio.excepcion.LendingClientMustExistException;
import com.ceiba.lendings.dominio.excepcion.LendingMustBeCreatedException;
import com.ceiba.lendings.dominio.repositorio.lending.LendingRepository;
import com.ceiba.lendings.dominio.servicio.lending.CreateLendingService;
import com.ceiba.lendings.dominio.servicio.lending.UpdateLendingService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ManageLendingServiceTest {

    @Test
    public void validateCreateLendingIfClientNotExists() {
        Lending lending=new LendingTestDataBuilder().build();
        LendingRepository lendingRepository = Mockito.mock(LendingRepository.class);
        Mockito.when(lendingRepository.checkIfLendingClientExists(Mockito.any())).thenReturn(false);

        CreateLendingService lendingService = new CreateLendingService(lendingRepository);
        BaseTest.assertThrows(()-> lendingService.createLending(lending), LendingClientMustExistException.class, "El cliente del prestamo que esta enviando no esta registrado");
    }

    @Test
    public void validateUpdateLendingIfNotExist() {
        Lending lending=new LendingTestDataBuilder().build();
        LendingRepository lendingRepository = Mockito.mock(LendingRepository.class);
        Mockito.when(lendingRepository.checkIfLendingClientExists(Mockito.any())).thenReturn(false);

        UpdateLendingService lendingService = new UpdateLendingService(lendingRepository);
        BaseTest.assertThrows(()-> lendingService.updateLending(lending), LendingMustBeCreatedException.class, "El prestamo que desea actualizar no esta registrado");
    }
}
