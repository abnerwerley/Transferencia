package com.transferencia.itau.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.transferencia.itau.entities.Cliente;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferenciaResponse {

    private Long idTransferencia;
    private Long numeroContaOrigem;
    private Long saldoOrigem;
    private Long numeroContaDestinatario;
    private Long valorTransferencia;
    @JsonFormat(pattern = "dd/MM/YYYY | HH:mm:ss")
    private LocalDateTime data;
    private boolean sucesso;
    private Cliente clienteOrigem;
    private Cliente destinatario;
}
