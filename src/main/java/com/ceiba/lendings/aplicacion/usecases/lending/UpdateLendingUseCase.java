package com.ceiba.lendings.aplicacion.usecases.lending;

import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.aplicacion.factory.LendingFactory;
import com.ceiba.lendings.aplicacion.services.LendingService;
import com.ceiba.lendings.aplicacion.usecases.UseCase;
import com.ceiba.lendings.dominio.entidades.Lending;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

@Component
public class UpdateLendingUseCase implements UseCase<LendingCommand, Boolean> {

    private final LendingFactory lendingFactory;

    @Inject
    private LendingService lendingService;

    public UpdateLendingUseCase(LendingFactory lendingFactory) {
        super();
        this.lendingFactory = lendingFactory;
    }

    @Override
    public Boolean execute(LendingCommand input) throws Exception {
        Lending lending = this.lendingFactory.createLending(input);
        return lendingService.updateLending(lending);
    }
}