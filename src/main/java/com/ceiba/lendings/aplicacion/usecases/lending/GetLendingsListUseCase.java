package com.ceiba.lendings.aplicacion.usecases.lending;

import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.aplicacion.excepcion.UseCaseException;
import com.ceiba.lendings.aplicacion.services.LendingService;
import com.ceiba.lendings.aplicacion.usecases.UseCase;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import com.ceiba.lendings.dominio.entidades.Lending;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class GetLendingsListUseCase implements UseCase<Void, List<LendingCommand>> {

    private ModelMapper modelMapper = new ModelMapper();

    @Inject
    private LendingService lendingService;

    @Override
    public List<LendingCommand> execute(Void input) throws UseCaseException {
        List<Lending> lendings = lendingService.getLendings();
        List<LendingCommand> list = new ArrayList<>();
        for(int i=0;i<lendings.size();i++) {
            list.add(modelMapper.map(lendings.get(i),LendingCommand.class));
        }
        return list;
    }
}
