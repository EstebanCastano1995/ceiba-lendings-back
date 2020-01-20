package com.ceiba.lendings.infraestructura.controller;

import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.aplicacion.usecases.lending.CreateLendingUseCase;
import com.ceiba.lendings.aplicacion.usecases.lending.GetLendingsListUseCase;
import com.ceiba.lendings.aplicacion.usecases.lending.UpdateLendingUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/service/lending")
public class LendingController {

    private CreateLendingUseCase createLendingUseCase;

    private GetLendingsListUseCase getLendingsListUseCase;

    private UpdateLendingUseCase updateLendingUseCase;

    @Autowired
    public LendingController( CreateLendingUseCase createLendingUseCase,GetLendingsListUseCase getLendingsListUseCase,UpdateLendingUseCase updateLendingUseCase) {
    this.createLendingUseCase=createLendingUseCase;
    this.getLendingsListUseCase=getLendingsListUseCase;
    this.updateLendingUseCase=updateLendingUseCase;
    }

    @GetMapping
    public ResponseEntity<List<LendingCommand>> getLendings() {
       List<LendingCommand> lendings= this.getLendingsListUseCase.execute();
       return new ResponseEntity<>(lendings, HttpStatus.OK);
    }

    @PostMapping
    public void createLending(@RequestBody LendingCommand lendingCommand) {
          createLendingUseCase.execute(lendingCommand);
    }

    @PutMapping(value = "/{id}")
    public void updateLending(@PathVariable Long id,@RequestBody LendingCommand lendingCommand) {
        lendingCommand.setId(id);
        updateLendingUseCase.execute(lendingCommand);
    }
}
