package com.ceiba.lendings.aplicacion.factory;

import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.dominio.entidades.Lending;
import org.springframework.stereotype.Component;

@Component
public class LendingFactory {

    public Lending createLending(LendingCommand lendingCommand){
        return new Lending(lendingCommand.getId(), lendingCommand.getLending_return_date(), lendingCommand.getLending_total_amount(),
                lendingCommand.getLending_value(), lendingCommand.getLending_date());
    }
}