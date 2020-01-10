package com.ceiba.lendings.infraestructura.controller;

import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.aplicacion.usecases.lending.CreateLendingUseCase;
import com.ceiba.lendings.aplicacion.usecases.lending.GetLendingsListUseCase;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@RestController
public class lendingController {

    private CreateLendingUseCase createLendingUseCase;

    private GetLendingsListUseCase getLendingsListUseCase;

    @Autowired
    public lendingController( CreateLendingUseCase createLendingUseCase,GetLendingsListUseCase getLendingsListUseCase) {
    this.createLendingUseCase=createLendingUseCase;
    this.getLendingsListUseCase=getLendingsListUseCase;
    }

    @RequestMapping(value = "/lending",method = RequestMethod.GET)
    public List<LendingCommand> getLendings() {
        try {
            return this.getLendingsListUseCase.execute(null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @RequestMapping(value = "/lending",method = RequestMethod.POST)
    public Boolean createLending(@RequestBody LendingCommand lendingCommand) {
        try {
            return createLendingUseCase.execute(lendingCommand);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
