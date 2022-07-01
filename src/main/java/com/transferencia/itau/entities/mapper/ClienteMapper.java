package com.transferencia.itau.entities.mapper;

import com.transferencia.itau.entities.Cliente;
import com.transferencia.itau.json.ClienteForm;

import java.util.Random;

public class ClienteMapper {

    public static Cliente fromFormToEntity(ClienteForm clienteForm){
        Random gerador = new Random();
        long numero = gerador.nextLong()/-1000000000;

        return Cliente.builder()
                .nome(clienteForm.getNome())
                .saldo(clienteForm.getSaldo())
                .numeroConta(numero/-10000)
                .build();
    }
}
