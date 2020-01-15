package com.ceiba.lendings.dominio.servicio.lending;

import com.ceiba.lendings.dominio.entidades.Lending;
import com.ceiba.lendings.dominio.excepcion.LendingClientMustExistException;
import com.ceiba.lendings.dominio.repositorio.lending.LendingRepository;

public class CreateLendingService {

    private static final String CLIENT_DOES_NOT_EXIST = "El cliente del prestamo que esta enviando no esta registrado";

    private LendingRepository lendingRepository;

    public CreateLendingService(LendingRepository lendingRepository) {
        this.lendingRepository = lendingRepository;
    }

    public void createLending(Lending lending) {
          checkIfLendingClientExists(lending);
          lendingRepository.createLending(lending);
    }

    private void checkIfLendingClientExists(Lending lending){
       if(!lendingRepository.checkIfLendingClientExists(lending))
           throw new LendingClientMustExistException(CLIENT_DOES_NOT_EXIST);
    }
}
