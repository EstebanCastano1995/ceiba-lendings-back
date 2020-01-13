package com.ceiba.lendings.aplicacion.usecases.lending;

import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.aplicacion.excepcion.UseCaseException;
import com.ceiba.lendings.aplicacion.factory.LendingFactory;
import com.ceiba.lendings.aplicacion.services.LendingService;
import com.ceiba.lendings.aplicacion.usecases.UseCase;
import com.ceiba.lendings.dominio.entidades.Lending;
import javax.inject.Inject;
import org.springframework.stereotype.Component;

@Component
public class CreateLendingUseCase implements UseCase<LendingCommand, Boolean> {

    private final LendingFactory lendingFactory;

    @Inject
    private LendingService lendingService;

    public CreateLendingUseCase(LendingFactory lendingFactory) {
        super();
        this.lendingFactory = lendingFactory;
    }

    @Override
    public Boolean execute(LendingCommand input) throws UseCaseException {
        Lending lending = this.lendingFactory.createLending(input);
        return lendingService.createLending(lending);
    }
}