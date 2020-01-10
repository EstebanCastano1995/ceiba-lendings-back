package com.ceiba.lendings.dominio.servicio.lending;

import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.aplicacion.services.LendingService;
import com.ceiba.lendings.dominio.entidades.Lending;
import java.util.List;
import com.ceiba.lendings.dominio.repositorio.client.ClientRepository;
import com.ceiba.lendings.dominio.repositorio.lending.LendingRepository;
import com.ceiba.lendings.infraestructura.entidades.ClientEntity;
import com.ceiba.lendings.infraestructura.entidades.LendingEntity;
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
}
