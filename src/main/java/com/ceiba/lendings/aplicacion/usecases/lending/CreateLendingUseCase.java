package com.ceiba.lendings.aplicacion.usecases.lending;

import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.aplicacion.factory.LendingFactory;
import com.ceiba.lendings.aplicacion.usecases.UseCaseVoid;
import com.ceiba.lendings.dominio.entidades.Lending;
import com.ceiba.lendings.dominio.servicio.lending.CreateLendingService;
import org.springframework.stereotype.Component;

@Component
public class CreateLendingUseCase implements UseCaseVoid<LendingCommand> {

    private final LendingFactory lendingFactory;

    private CreateLendingService createLendingService;

    public CreateLendingUseCase(LendingFactory lendingFactory,CreateLendingService createLendingService) {
        this.lendingFactory = lendingFactory;
        this.createLendingService=createLendingService;
    }

    @Override
    public void execute(LendingCommand input) {
        Lending lending = this.lendingFactory.createLending(input);
        createLendingService.createLending(lending);
    }
}