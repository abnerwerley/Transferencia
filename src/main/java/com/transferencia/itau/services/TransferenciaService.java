package com.transferencia.itau.services;

import com.transferencia.itau.json.TransferenciaResponse;
import com.transferencia.itau.json.mapper.TransferenciaResponseMapper;
import com.transferencia.itau.persistence.TransferenciaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository repository;

    public Page<TransferenciaResponse> findAllTransferencias (Pageable pageable){
        return repository.findAll(pageable).map(TransferenciaResponseMapper::fromEntityToResponse);
    }
}
