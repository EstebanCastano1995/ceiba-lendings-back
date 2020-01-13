package com.ceiba.lendings.aplicacion.services;

import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.dominio.entidades.Lending;

import java.util.List;

public interface LendingService {
    List<LendingCommand> getLendings();
    Boolean createLending(Lending lending);
    Boolean updateLending(Lending lending);
}
