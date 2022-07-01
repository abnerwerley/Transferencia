package com.transferencia.itau.json.mapper;

import com.transferencia.itau.entities.Cliente;
import com.transferencia.itau.json.ClienteResponse;

public class ClienteResponseMapper {

    public static ClienteResponse fromEntityToResponse(Cliente cliente){
        return ClienteResponse.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .numeroConta(cliente.getNumeroConta())
                .saldo(cliente.getSaldo())
                .build();
    }
}
