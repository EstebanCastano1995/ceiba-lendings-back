package com.ceiba.lendings.dominio.servicio.lending;

import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.aplicacion.services.LendingService;
import com.ceiba.lendings.dominio.entidades.Lending;
import java.util.List;
import com.ceiba.lendings.dominio.repositorio.lending.LendingRepository;
import org.springframework.stereotype.Service;
import javax.inject.Inject;

@Service
public class LendingServiceImpl implements LendingService{

    @Inject
    private LendingRepository lendingRepository;

    @Override
    public List<LendingCommand> getLendings() {
        return lendingRepository.getLendings();
    }

    @Override
    public Boolean createLending(Lending lending) {
        return  lendingRepository.createLending(lending);
    }

    @Override
    public Boolean updateLending(Lending lending) {
        return  lendingRepository.updateLending(lending);
    }
}
