package com.transferencia.itau.json.mapper;

import com.transferencia.itau.entities.Transferencia;
import com.transferencia.itau.json.TransferenciaResponse;

public class TransferenciaResponseMapper {

    private TransferenciaResponseMapper() {
    }

    public static TransferenciaResponse fromEntityToResponse(Transferencia transferencia) {
        return TransferenciaResponse.builder()
                .idTransferencia(transferencia.getIdTransferencia())
                .numeroContaDestinatario(transferencia.getNumeroContaDestinatario())
                .numeroContaOrigem(transferencia.getNumeroContaOrigem())
                .destinatario(transferencia.getDestinatario())
                .clienteOrigem(transferencia.getContaOrigem())
                .sucesso(transferencia.isSucesso())
                .data(transferencia.getData())
                .saldoOrigem(transferencia.getSaldoOrigem())
                .valorTransferencia(transferencia.getValorTransferencia())
                .build();
    }

}
