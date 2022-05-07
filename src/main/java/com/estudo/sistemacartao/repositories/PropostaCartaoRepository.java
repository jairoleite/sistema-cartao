package com.estudo.sistemacartao.repositories;

import com.estudo.sistemacartao.entities.PropostaCartao;
import com.estudo.sistemacartao.entities.enums.PropostaStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropostaCartaoRepository extends JpaRepository<PropostaCartao, Long> {

    List<PropostaCartao> findAllStatusOrderByDataRegistro(String status);
}
