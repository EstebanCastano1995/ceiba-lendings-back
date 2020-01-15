package com.ceiba.lendings.infraestructura.adaptador.repositorio.lending;

import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.dominio.entidades.Lending;
import com.ceiba.lendings.dominio.repositorio.lending.LendingRepository;
import com.ceiba.lendings.infraestructura.entidades.LendingEntity;
import com.ceiba.lendings.infraestructura.jpa.LendingJPA;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LendingRepositoryJpa implements LendingRepository {

    @Autowired
    private LendingJPA lendingJPA;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<Lending> getLendings() {
        List<LendingEntity> lendingEntities = lendingJPA.findAll();
        List<Lending> list = new ArrayList<>();
        for(int i=0;i<lendingEntities.size();i++) {
            list.add(modelMapper.map(lendingEntities.get(i),Lending.class));
        }
        return list;
    }

    @Override
    public Boolean createLending(Lending lending) {
        LendingEntity lendingEntity = modelMapper.map(lending, LendingEntity.class);
        lendingJPA.save(lendingEntity);
        return this.checkIfExists(lendingEntity.getId());
    }

    @Override
    public Boolean updateLending(Lending lending) {
        LendingEntity lendingEntity = modelMapper.map(lending, LendingEntity.class);
        lendingJPA.save(lendingEntity);
        return this.checkIfExists(lendingEntity.getId());
    }

    private Boolean checkIfExists(Long id) {
        return lendingJPA.existsById(id);
    }
}
