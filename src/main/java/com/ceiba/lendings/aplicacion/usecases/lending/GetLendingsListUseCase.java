package com.ceiba.lendings.aplicacion.usecases.lending;

import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.aplicacion.services.LendingService;
import com.ceiba.lendings.aplicacion.usecases.UseCase;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Component;

@Component
public class GetLendingsListUseCase implements UseCase<Void, List<LendingCommand>> {

    @Inject
    private LendingService lendingService;

    @Override
    public List<LendingCommand> execute(Void input) throws Exception {
        return lendingService.getLendings();
    }
}
