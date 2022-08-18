package com.transferencia.itau.json;

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
    private Long numeroContaTransferidor;
    private Long saldoTransferidor;
    private Long numeroContaRecebidor;
    private Long saldoRecebidor;
    private LocalDateTime data;
    private boolean sucesso;
    private Cliente transferidor;
    private Cliente recebidor;
}
