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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AnexarPropostaCartaoJob5 {

    private CartaoClienteService cartaoClienteService;
    private CartaoRepository cartaoRepository;
    private PropostaCartaoRepository propostaCartaoRepository;

    private TransactionTemplate transactionManager;


    @Scheduled(fixedDelay = 60_000)
    public void execute() {

        boolean pendente = true;

        while (pendente) {
            pendente = Boolean.TRUE.equals(transactionManager.execute(transactionalStatus -> {
                List<PropostaCartao> propostas = propostaCartaoRepository.findTop50StatusOrderByDataRegistro(PropostaStatusEnum.ELEGIVEL.toString());

                if (propostas.isEmpty()) {
                    return false;
                }

                propostas.forEach(proposta -> {
                    Cartao cartao = cartaoClienteService.buscaCartaoPorPropostaId(proposta.getId());
                    cartaoRepository.save(cartao);

                    proposta.setCartaoUUID(cartao.getUuid());
                    propostaCartaoRepository.save(proposta);
                });
                return true;
            }));
        }
    }

}
