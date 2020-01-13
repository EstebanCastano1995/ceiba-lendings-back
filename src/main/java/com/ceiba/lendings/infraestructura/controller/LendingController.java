package com.ceiba.lendings.infraestructura.controller;

import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.aplicacion.excepcion.UseCaseException;
import com.ceiba.lendings.aplicacion.usecases.lending.CreateLendingUseCase;
import com.ceiba.lendings.aplicacion.usecases.lending.GetLendingsListUseCase;
import com.ceiba.lendings.aplicacion.usecases.lending.UpdateLendingUseCase;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class LendingController {

    private static final Logger LOGGER = Logger.getLogger(LendingController.class.getName());

    private CreateLendingUseCase createLendingUseCase;

    private GetLendingsListUseCase getLendingsListUseCase;

    private UpdateLendingUseCase updateLendingUseCase;

    @Autowired
    public LendingController( CreateLendingUseCase createLendingUseCase,GetLendingsListUseCase getLendingsListUseCase,UpdateLendingUseCase updateLendingUseCase) {
    this.createLendingUseCase=createLendingUseCase;
    this.getLendingsListUseCase=getLendingsListUseCase;
    this.updateLendingUseCase=updateLendingUseCase;
    }

    @RequestMapping(value = "/lending",method = RequestMethod.GET)
    public List<LendingCommand> getLendings() {
        try {
            return this.getLendingsListUseCase.execute(null);
        } catch (UseCaseException e) {
            LOGGER.log(Level.INFO,"Exception getting lendings",e);
            return new ArrayList<>();
        }
    }

    @RequestMapping(value = "/lending",method = RequestMethod.POST)
    public Boolean createLending(@RequestBody LendingCommand lendingCommand) {
        try {
            return createLendingUseCase.execute(lendingCommand);
        } catch (UseCaseException e) {
            LOGGER.log(Level.INFO,"Exception saving lending",e);
            return false;
        }
    }

    @RequestMapping(value = "/lending/update",method = RequestMethod.POST)
    public Boolean updateLending(@RequestBody LendingCommand lendingCommand) {
        try {
            return updateLendingUseCase.execute(lendingCommand);
        } catch (UseCaseException e) {
            LOGGER.log(Level.INFO,"Exception updating lending",e);
            return false;
        }
    }

}
