package com.transferencia.itau.controllers;

import com.transferencia.itau.json.ClienteForm;
import com.transferencia.itau.json.ClienteResponse;
import com.transferencia.itau.services.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {

    @Autowired
    private ClienteService service;

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("")
    public ClienteResponse cadastrarCliente(@RequestBody ClienteForm form) {
        return service.cadastraCliente(form);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("")
    Page<ClienteResponse> findClientes(@RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                                       @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return service.findAllClientes(PageRequest.of(pageNumber, pageSize));
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/{numeroConta}")
    Optional<ClienteResponse> findClientePorNumeroConta(@RequestParam Long numeroConta) {
        return service.findClientePorNumeroConta(numeroConta);
    }

}
