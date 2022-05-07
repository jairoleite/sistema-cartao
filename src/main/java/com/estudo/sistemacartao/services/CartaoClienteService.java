package com.estudo.sistemacartao.services;

import com.estudo.sistemacartao.entities.Cartao;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CartaoClienteService {

    private final RestTemplate rest = new RestTemplate();

    public Cartao buscaCartaoPorPropostaId(final Long propostaId) {
        ResponseEntity<Cartao> cartaoResponse = rest.getForEntity("url banco", Cartao.class);
        return cartaoResponse.getBody();
    }
}
