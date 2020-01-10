package com.ceiba.lendings.dominio.repositorio.lending;

import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.dominio.entidades.Lending;

import java.util.List;

public interface LendingRepository {
    List<LendingCommand> getLendings();
    Boolean createLending(Lending lending);
}
