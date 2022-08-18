package com.transferencia.itau.json.mapper;

import com.transferencia.itau.entities.Cliente;
import com.transferencia.itau.json.ClienteResponse;

public class ClienteResponseMapper {

    private ClienteResponseMapper() {
    }

    public static ClienteResponse fromEntityToResponse(Cliente cliente){
        return ClienteResponse.builder()
                .idCliente(cliente.getIdCliente())
                .nome(cliente.getNome())
                .numeroConta(cliente.getNumeroConta())
                .saldo(cliente.getSaldo())
                .transferencias(cliente.getTransferencias())
                .build();
    }
}
