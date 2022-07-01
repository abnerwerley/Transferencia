package com.transferencia.itau.json;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteResponse {

    private Long id;
    private String nome;
    private Long numeroConta;
    private Long saldo;
}
