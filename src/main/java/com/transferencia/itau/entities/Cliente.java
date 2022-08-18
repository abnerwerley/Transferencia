package com.transferencia.itau.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"cliente"})
    private List<Transferencia> transferencias = new ArrayList<>();
}
