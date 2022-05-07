package com.estudo.sistemacartao.jobs;

import com.estudo.sistemacartao.entities.Cartao;
import com.estudo.sistemacartao.entities.PropostaCartao;
import com.estudo.sistemacartao.entities.enums.PropostaStatusEnum;
import com.estudo.sistemacartao.repositories.CartaoRepository;
import com.estudo.sistemacartao.repositories.PropostaCartaoRepository;
import com.estudo.sistemacartao.services.CartaoClienteService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class AnexarPropostaCartaoJob3 {

    private CartaoClienteService cartaoClienteService;
    private CartaoRepository cartaoRepository;
    private PropostaCartaoRepository propostaCartaoRepository;

    @Transactional
    @Scheduled(fixedDelay = 60_000)
    public void execute() {

        while (true) {
            List<PropostaCartao> propostas = propostaCartaoRepository.findTop50StatusOrderByDataRegistro(PropostaStatusEnum.ELEGIVEL.toString());

            if(propostas.isEmpty()) {
                break;
            }

            propostas.forEach(proposta -> {
                // processa cada proposta
            });
        }
    }

}
