package com.transferencia.itau.persistence;

import com.transferencia.itau.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findClienteByNumeroConta(Long numeroConta);
}
