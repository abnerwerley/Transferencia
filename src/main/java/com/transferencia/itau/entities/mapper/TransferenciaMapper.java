package com.transferencia.itau.entities.mapper;

import com.transferencia.itau.entities.Transferencia;
import com.transferencia.itau.json.TransferenciaForm;

public class TransferenciaMapper {

    private TransferenciaMapper() {
    }

    public static Transferencia fromFormToEntity(TransferenciaForm form) {
        return Transferencia.builder()
                .numeroContaDestinatario(form.getNumeroContaDestinatario())
                .numeroContaOrigem(form.getNumeroContaOrigem())
                .build();
    }
}
