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
    public List<LendingCommand> getLendings() {
        List<LendingEntity> lendingEntities = lendingJPA.findAll();
        List<LendingCommand> list = new ArrayList<>();
        for(int i=0;i<lendingEntities.size();i++) {
            list.add(modelMapper.map(lendingEntities.get(i),LendingCommand.class));
        }
        return list;
    }

    @Override
    public Boolean createLending(Lending lending) {
        LendingEntity lendingEntity = modelMapper.map(lending, LendingEntity.class);
        lendingJPA.save(lendingEntity);
        return true;
    }

    @Override
    public Boolean updateLending(Lending lending) {
        LendingEntity lendingEntity = modelMapper.map(lending, LendingEntity.class);
        lendingJPA.save(lendingEntity);
        return true;
    }

    private Boolean translateResult(Integer result) {
        return result>0?true:false;
    }
}
