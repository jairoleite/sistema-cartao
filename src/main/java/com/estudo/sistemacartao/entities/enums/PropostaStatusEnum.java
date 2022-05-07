package com.estudo.sistemacartao.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public enum PropostaStatusEnum {
    ILEGIVEL, APROVADO, REPROVADO;
}
