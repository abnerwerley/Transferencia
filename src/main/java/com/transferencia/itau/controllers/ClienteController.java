package com.transferencia.itau.controllers;

import com.transferencia.itau.json.ClienteForm;
import com.transferencia.itau.json.ClienteResponse;
import com.transferencia.itau.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping
    public ClienteResponse cadastrarCliente(@RequestBody ClienteForm form){
        return service.cadastraCliente(form);
    }
}
