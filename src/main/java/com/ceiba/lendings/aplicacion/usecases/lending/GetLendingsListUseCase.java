package com.ceiba.lendings.aplicacion.usecases.lending;

import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.aplicacion.usecases.UseCaseReturn;
import java.util.ArrayList;
import java.util.List;
import com.ceiba.lendings.dominio.entidades.Lending;
import com.ceiba.lendings.dominio.servicio.lending.GetLendingsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class GetLendingsListUseCase implements UseCaseReturn<List<LendingCommand>> {

    private ModelMapper modelMapper = new ModelMapper();

    private GetLendingsService getLendingsService;

    public GetLendingsListUseCase(GetLendingsService getLendingsService) {
        this.getLendingsService=getLendingsService;
    }

    @Override
    public List<LendingCommand> execute() {
        List<Lending> lendings = getLendingsService.getLendings();
        List<LendingCommand> list = new ArrayList<>();
        for(int i=0;i<lendings.size();i++) {
            list.add(modelMapper.map(lendings.get(i),LendingCommand.class));
        }
        return list;
    }
}
