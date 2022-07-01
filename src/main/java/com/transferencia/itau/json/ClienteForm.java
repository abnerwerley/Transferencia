package com.transferencia.itau.json;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteForm {

    private String nome;
    private Long saldo;
}
