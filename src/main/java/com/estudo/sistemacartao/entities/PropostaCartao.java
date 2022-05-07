package com.estudo.sistemacartao.entities;

import com.estudo.sistemacartao.entities.enums.PropostaStatusEnum;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "PropostaCartao")
@Data
public class PropostaCartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cartaoUUID;
    private String status;
    private Instant dataRegistro;
}
