package com.transferencia.itau.persistence;

import com.transferencia.itau.entities.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    Transferencia findByIdTransferencia(Long idTransferencia);

    Transferencia findByNumeroContaTransferidor(Long numeroContaTransferidor);
}
