package com.ceiba.lendings.dominio.servicio.lending;

import com.ceiba.lendings.dominio.entidades.Lending;
import com.ceiba.lendings.dominio.repositorio.lending.LendingRepository;
import java.util.List;

public class GetLendingsService {

    private LendingRepository lendingRepository;

    public GetLendingsService(LendingRepository lendingRepository) {
        this.lendingRepository = lendingRepository;
    }

    public List<Lending> getLendings() {
        return lendingRepository.getLendings();
    }
}
