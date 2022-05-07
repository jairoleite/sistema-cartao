package com.estudo.sistemacartao.repositories;

import com.estudo.sistemacartao.entities.PropostaCartao;
import com.estudo.sistemacartao.entities.enums.PropostaStatusEnum;
import org.hibernate.LockOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface PropostaCartaoRepository extends JpaRepository<PropostaCartao, Long> {

    List<PropostaCartao> findAllStatusOrderByDataRegistro(String status);

    @QueryHints(value = {
            @QueryHint(
                    name = "javax.persistence.lock.timeout",
                    value = LockOptions.SKIP_LOCKED) // org.hibernate.LockOptions
    })
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<PropostaCartao> findTop50StatusOrderByDataRegistro(String status);
}
