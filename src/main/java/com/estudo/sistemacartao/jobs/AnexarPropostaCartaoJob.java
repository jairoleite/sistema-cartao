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

import java.util.List;

@Component
@RequiredArgsConstructor
public class AnexarPropostaCartaoJob {

    private CartaoClienteService cartaoClienteService;
    private CartaoRepository cartaoRepository;
    private PropostaCartaoRepository propostaCartaoRepository;

    @Transactional
    @Scheduled(fixedDelay = 60_000)
    public void execute() {

        List<PropostaCartao> propostas = propostaCartaoRepository.findAllStatusOrderByDataRegistro(PropostaStatusEnum.ILEGIVEL.toString());
        propostas.forEach(proposta -> {
            Cartao cartao = cartaoClienteService.buscaCartaoPorPropostaId(proposta.getId());
            cartaoRepository.save(cartao);

            proposta.setCartaoUUID(cartao.getUuid());
            propostaCartaoRepository.save(proposta);
        });
    }

}
