package com.transferencia.itau.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRANSFERENCE")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransferencia;
    private Long numeroContaOrigem;
    private Long saldoOrigem;
    private Long valorTransferencia;
    private Long numeroContaDestinatario;

    @JsonFormat(pattern = "dd/MM/YYYY | HH:mm:ss")
    private LocalDateTime data;
    private boolean sucesso;

    @ManyToOne
    @JsonIgnoreProperties({"transferencias"})
    private Cliente contaOrigem;

    @ManyToOne
    @JsonIgnoreProperties({"transferencias"})
    private Cliente destinatario;

}
