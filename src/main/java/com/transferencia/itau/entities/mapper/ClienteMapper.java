package com.transferencia.itau.entities.mapper;

import com.transferencia.itau.entities.Cliente;
import com.transferencia.itau.json.ClienteForm;

public class ClienteMapper {

    private ClienteMapper() {
    }

    public static Cliente fromFormToEntity(ClienteForm clienteForm){

        return Cliente.builder()
                .nome(clienteForm.getNome())
                .saldo(clienteForm.getSaldo())
                .numeroConta((long) Math.abs(Math.floor(Math.random()*1000000)))
                .build();
    }
}
