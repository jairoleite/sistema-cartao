package com.estudo.sistemacartao.jobs;

import com.estudo.sistemacartao.entities.Cartao;
import com.estudo.sistemacartao.entities.PropostaCartao;
import com.estudo.sistemacartao.entities.enums.PropostaStatusEnum;
import com.estudo.sistemacartao.repositories.CartaoRepository;
import com.estudo.sistemacartao.repositories.PropostaCartaoRepository;
import com.estudo.sistemacartao.services.CartaoClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AnexarPropostaCartaoJob6 {

    private CartaoClienteService cartaoClienteService;
    private CartaoRepository cartaoRepository;
    private PropostaCartaoRepository propostaCartaoRepository;

    private TransactionTemplate transactionManager;


    @Scheduled(fixedDelay = 60_000)
    public synchronized void execute() {
        // executa lógica aqui
    }

}
