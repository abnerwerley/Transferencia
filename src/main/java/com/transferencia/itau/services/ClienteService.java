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

import java.util.NoSuchElementException;
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

    public Optional<ClienteResponse> findClienteById(long id) {
        Optional<Cliente> cliente = repository.findClienteByIdCliente(id);

        if (cliente.isPresent()) {
            Cliente cliente1 = cliente.get();
            cliente1.getIdCliente();
            cliente1.getNome();
            cliente1.getNumeroConta();
            cliente1.getSaldo();

            return Optional.ofNullable(ClienteResponseMapper.fromEntityToResponse(cliente1));
        }
        throw new NoSuchElementException("There is no client with this id.");
    }

    public Page<ClienteResponse> findAllClientes(Pageable pageable) {
        return repository.findAll(pageable).map(ClienteResponseMapper::fromEntityToResponse);
    }
}
