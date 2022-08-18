package com.transferencia.itau.json;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferenciaForm {

    private Long numeroContaTransferidor;
    @NotBlank
    private Long saldoTransferidor;
    @NotBlank
    private Long numeroContaRecebidor;
    @NotBlank
    private Long saldoRecebidor;
}