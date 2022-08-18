package com.transferencia.itau.json.mapper;

import com.transferencia.itau.entities.Transferencia;
import com.transferencia.itau.json.TransferenciaResponse;

public class TransferenciaResponseMapper {

    private TransferenciaResponseMapper() {
    }

    public static TransferenciaResponse fromEntityToResponse(Transferencia transferencia) {
        return TransferenciaResponse.builder()
                .idTransferencia(transferencia.getIdTransferencia())
                .numeroContaRecebidor(transferencia.getNumeroContaRecebidor())
                .numeroContaTransferidor(transferencia.getNumeroContaTransferidor())
                .recebidor(transferencia.getRecebidor())
                .transferidor(transferencia.getTransferidor())
                .sucesso(transferencia.isSucesso())
                .data(transferencia.getData())
                .saldoRecebidor(transferencia.getSaldoRecebidor())
                .saldoTransferidor(transferencia.getSaldoTransferidor())
                .build();
    }

}
