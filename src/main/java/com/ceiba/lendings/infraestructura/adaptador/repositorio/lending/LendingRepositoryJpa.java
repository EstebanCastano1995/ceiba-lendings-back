package com.ceiba.lendings.infraestructura.adaptador.repositorio.lending;

import com.ceiba.lendings.dominio.entidades.Lending;
import com.ceiba.lendings.dominio.repositorio.lending.LendingRepository;
import com.ceiba.lendings.infraestructura.entidades.ClientEntity;
import com.ceiba.lendings.infraestructura.entidades.LendingEntity;
import com.ceiba.lendings.infraestructura.jpa.ClientJPA;
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

    @Autowired
    private ClientJPA clientJPA;

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
    public void createLending(Lending lending) {
        LendingEntity lendingEntity = modelMapper.map(lending, LendingEntity.class);
        lendingJPA.save(lendingEntity);
    }

    @Override
    public Boolean checkIfLendingExists(Lending lending) {
        LendingEntity lendingEntity = modelMapper.map(lending, LendingEntity.class);
        return lendingJPA.existsById(lendingEntity.getId());
    }

    @Override
    public Boolean checkIfLendingClientExists(Lending lending) {
        LendingEntity lendingEntity = modelMapper.map(lending, LendingEntity.class);
        return clientJPA.existsById(lendingEntity.getClientid().getId());
    }
}
