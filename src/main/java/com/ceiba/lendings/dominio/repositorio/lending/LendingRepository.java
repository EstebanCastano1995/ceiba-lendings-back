package com.ceiba.lendings.dominio.repositorio.lending;

import com.ceiba.lendings.dominio.entidades.Lending;
import java.util.List;

public interface LendingRepository {
    List<Lending> getLendings();
    Boolean createLending(Lending lending);
    Boolean updateLending(Lending lending);
}
