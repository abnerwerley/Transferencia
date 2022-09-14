package com.transferencia.itau.json;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferenciaForm {

    @NotEmpty
    private Long numeroContaOrigem;
    @NotEmpty
    private Long valorTransferencia;
    @NotEmpty
    private Long numeroContaDestinatario;
}