package com.transferencia.itau.services;

import com.transferencia.itau.entities.Cliente;
import com.transferencia.itau.entities.Transferencia;
import com.transferencia.itau.entities.mapper.TransferenciaMapper;
import com.transferencia.itau.exceptions.RequestException;
import com.transferencia.itau.json.TransferenciaForm;
import com.transferencia.itau.json.TransferenciaResponse;
import com.transferencia.itau.json.mapper.TransferenciaResponseMapper;
import com.transferencia.itau.persistence.ClienteRepository;
import com.transferencia.itau.persistence.TransferenciaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Page<TransferenciaResponse> findAllTransferencias(Pageable pageable) {
        try {
            return repository.findAll(pageable).map(TransferenciaResponseMapper::fromEntityToResponse);
        } catch (Exception e) {
            log.error("Erro no service ao buscar transferencias.");
            throw new RequestException("Erro no service ao buscar transferencias.");
        }

    }

    public TransferenciaResponse transferir(TransferenciaForm form) {
        try {
            Cliente origem = clienteRepository.findClienteByNumeroConta(form.getNumeroContaOrigem());
            Cliente destinatario = clienteRepository.findClienteByNumeroConta(form.getNumeroContaDestinatario());
            if (form.getValorTransferencia() < 1000) {

                if (origem != null && destinatario != null) {
                    Long saldoDestinatario = destinatario.getSaldo();
                    Long saldoOrigem = origem.getSaldo();

                    if (form.getValorTransferencia() > 0) {
                        if (saldoOrigem >= form.getValorTransferencia()) {
                            destinatario.setSaldo(saldoDestinatario + form.getValorTransferencia());
                            origem.setSaldo(saldoOrigem - form.getValorTransferencia());

                            Transferencia transferencia = salvaTransferencia(form, origem, destinatario, true);
                            return TransferenciaResponseMapper.fromEntityToResponse(transferencia);

                        } else {
                            salvaTransferencia(form, origem, destinatario, false);
                            log.error("Saldo infuciente.");
                            throw new RequestException("Saldo infuciente.");
                        }
                    } else {
                        log.error("O valor da transferência deve ser maior que 0.");
                        throw new RequestException("O valor da transferência deve ser maior que 0.");
                    }
                } else {
                    throw new RequestException("Deve ter um destinatário e cliente de origem para realizar a transferência..");
                }
            }
            log.error("Valor da transferência acima do permitido.");
            throw new RequestException("Valor da transferência acima do permitido.");
        } catch (Exception e) {
            log.error("Erro ao fazer transferência.");
            throw new RequestException("Verifique os dados passados e tente novamente.");
        }
    }

    public Transferencia salvaTransferencia(TransferenciaForm form, Cliente origem, Cliente destinatario, boolean sucesso) {
        try {
            Long saldoOrigem = origem.getSaldo();

            Transferencia transferencia = TransferenciaMapper.fromFormToEntity(form);
            transferencia.setData(LocalDateTime.now());
            transferencia.setDestinatario(destinatario);
            transferencia.setContaOrigem(origem);
            transferencia.setSaldoOrigem(saldoOrigem);
            transferencia.setSucesso(sucesso);
            transferencia.setValorTransferencia(form.getValorTransferencia());//necessário?
            transferencia.setNumeroContaOrigem(form.getNumeroContaOrigem());
            transferencia.setNumeroContaDestinatario(form.getNumeroContaDestinatario());
            repository.save(transferencia);

            return transferencia;
        } catch (Exception e) {
            log.error("Erro no service de transferência para salvar transferência.");
            throw new RequestException("Erro ao salvar transferência.");
        }
    }
}
