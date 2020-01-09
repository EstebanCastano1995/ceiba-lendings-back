package co.com.ceiba.restservice.lendings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class lendingController {

    @Autowired
    public lendingController() {

    }

    @RequestMapping(value = "/greeting",method = RequestMethod.GET)
    public String testController() {
        return "HOLA";
    }


}
