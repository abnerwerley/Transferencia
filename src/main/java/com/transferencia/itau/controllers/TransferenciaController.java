package com.transferencia.itau.controllers;

import com.transferencia.itau.json.TransferenciaResponse;
import com.transferencia.itau.services.TransferenciaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transferencia")
@AllArgsConstructor
public class TransferenciaController {

    @Autowired
    private TransferenciaService service;

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("")
    Page<TransferenciaResponse> findTransferencias(@RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                                                   @RequestParam(required = false, defaultValue = "10") Integer pageSize){
        return service.findAllTransferencias(PageRequest.of(pageNumber, pageSize));
    }


}
