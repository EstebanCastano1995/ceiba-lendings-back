package com.ceiba.lendings.aplicacion.factory;

import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.dominio.entidades.Lending;
import com.ceiba.lendings.dominio.entidades.Client;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LendingFactory {

    private ModelMapper modelMapper = new ModelMapper();

    public Lending createLending(LendingCommand lendingCommand){
        return new Lending(lendingCommand.getId(), lendingCommand.getLending_return_date(),
                lendingCommand.getLending_value(), lendingCommand.getLending_date(), modelMapper.map(lendingCommand.getClient_id(),Client.class));
    }
}