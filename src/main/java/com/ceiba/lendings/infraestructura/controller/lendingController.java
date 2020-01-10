package com.ceiba.lendings.infraestructura.controller;

import com.ceiba.lendings.aplicacion.comando.command.LendingCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class lendingController {

    public lendingController( ) {
    }

    @RequestMapping(value = "/lending",method = RequestMethod.GET)
    public String getLendings() {
        return "RETURNING LIST OF LENDINGS";
    }

    @RequestMapping(value = "/lending",method = RequestMethod.POST)
    public String createLending(@RequestBody LendingCommand lendingCommand) {
        return "you want to create a lending";
    }

}
