package com.transferencia.itau.services;

import com.transferencia.itau.entities.Cliente;
import com.transferencia.itau.entities.mapper.ClienteMapper;
import com.transferencia.itau.json.ClienteForm;
import com.transferencia.itau.json.ClienteResponse;
import com.transferencia.itau.json.mapper.ClienteResponseMapper;
import com.transferencia.itau.persistence.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ClienteService {


    @Autowired
    private ClienteRepository repository;

    public ClienteResponse cadastraCliente(ClienteForm form) {
        try {
            Cliente cliente = ClienteMapper.fromFormToEntity(form);
            return ClienteResponseMapper.fromEntityToResponse(repository.save(cliente));
        } catch (Exception e) {
            log.error("Erro no cadastro de cliente");
            e.printStackTrace();
            throw e;
        }
    }

    public Page<ClienteResponse> findAllClientes(Pageable pageable) {
        return repository.findAll(pageable).map(ClienteResponseMapper::fromEntityToResponse);
    }

    public Optional<ClienteResponse> findClientePorNumeroConta(Long numeroConta) {
        return Optional.ofNullable(ClienteResponseMapper.
                fromEntityToResponse(repository.findClienteByNumeroConta(numeroConta)));
    }
}
