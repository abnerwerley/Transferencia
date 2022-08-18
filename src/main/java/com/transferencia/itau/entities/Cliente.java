package com.transferencia.itau.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    @NotBlank
    private String nome;
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  numeroConta;
    private Long saldo;
}
