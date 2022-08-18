package com.transferencia.itau.json;

import com.transferencia.itau.entities.Transferencia;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteResponse {

    private Long idCliente;
    private String nome;
    private double numeroConta;
    private Long saldo;
    private List<Transferencia> transferencias;
}
