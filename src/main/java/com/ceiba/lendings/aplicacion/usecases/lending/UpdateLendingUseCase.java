package com.ceiba.lendings.aplicacion.usecases.lending;

import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.aplicacion.factory.LendingFactory;
import com.ceiba.lendings.aplicacion.usecases.UseCaseVoid;
import com.ceiba.lendings.dominio.entidades.Lending;
import com.ceiba.lendings.dominio.servicio.lending.UpdateLendingService;
import org.springframework.stereotype.Component;

@Component
public class UpdateLendingUseCase implements UseCaseVoid<LendingCommand> {

    private final LendingFactory lendingFactory;

    private UpdateLendingService updateLendingService;

    public UpdateLendingUseCase(LendingFactory lendingFactory,UpdateLendingService updateLendingService) {
        this.lendingFactory = lendingFactory;
        this.updateLendingService=updateLendingService;
    }

    @Override
    public void execute(LendingCommand input)  {
        Lending lending = this.lendingFactory.createLending(input);
        updateLendingService.updateLending(lending);
    }
}