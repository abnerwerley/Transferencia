package com.transferencia.itau.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank
    private Long numeroContaTransferidor;
    @NotBlank
    private Long saldoTransferidor;
    @NotBlank
    private Long numeroContaRecebidor;
    @NotBlank
    private Long saldoRecebidor;
    @NotBlank
    private LocalDateTime data;
    @NotBlank
    private boolean sucesso;

    @NotBlank
    @ManyToOne
    @JsonIgnoreProperties({"transferencias"})
    private Cliente transferidor;

    @NotBlank
    @ManyToOne
    @JsonIgnoreProperties({"transferencias"})
    private Cliente recebidor;

}
