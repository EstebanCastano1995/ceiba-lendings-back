package com.ceiba.lendings.infraestructura.controller;

import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.aplicacion.excepcion.UseCaseException;
import com.ceiba.lendings.aplicacion.usecases.lending.CreateLendingUseCase;
import com.ceiba.lendings.aplicacion.usecases.lending.GetLendingsListUseCase;
import com.ceiba.lendings.aplicacion.usecases.lending.UpdateLendingUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<LendingCommand>> getLendings() {
        try {
             List<LendingCommand> lendings= this.getLendingsListUseCase.execute(null);
            return new ResponseEntity<>(lendings, HttpStatus.OK);
        } catch (UseCaseException e) {
            LOGGER.log(Level.INFO,"Exception getting lendings",e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(value = "/lending",method = RequestMethod.POST)
    public ResponseEntity<Boolean> createLending(@RequestBody LendingCommand lendingCommand) {
        try {
            Boolean result=createLendingUseCase.execute(lendingCommand);
            return new ResponseEntity<>(result,HttpStatus.OK);
        } catch (UseCaseException e) {
            LOGGER.log(Level.INFO,"Exception saving lending",e);
            return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/lending/update",method = RequestMethod.POST)
    public ResponseEntity<Boolean> updateLending(@RequestBody LendingCommand lendingCommand) {
        try {
             Boolean result=updateLendingUseCase.execute(lendingCommand);
            return new ResponseEntity<>(result,HttpStatus.OK);
        } catch (UseCaseException e) {
            LOGGER.log(Level.INFO,"Exception updating lending",e);
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
