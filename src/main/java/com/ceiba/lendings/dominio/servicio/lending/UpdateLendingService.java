package com.ceiba.lendings.dominio.servicio.lending;

import com.ceiba.lendings.dominio.entidades.Lending;
import com.ceiba.lendings.dominio.excepcion.LendingMustBeCreatedException;
import com.ceiba.lendings.dominio.repositorio.lending.LendingRepository;

public class UpdateLendingService {

    private static final String LENDING_DOES_NOT_EXIST = "El prestamo que desea actualizar no esta registrado";

    private LendingRepository lendingRepository;

    public UpdateLendingService(LendingRepository lendingRepository) {
        this.lendingRepository = lendingRepository;
    }

    public void updateLending(Lending lending) {
        checkIfLendingExists(lending);
        lendingRepository.createLending(lending);
    }

    private void checkIfLendingExists(Lending lending){
        if(!lendingRepository.checkIfLendingExists(lending))
            throw new LendingMustBeCreatedException(LENDING_DOES_NOT_EXIST);
    }
}
