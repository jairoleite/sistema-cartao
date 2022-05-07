package com.estudo.sistemacartao.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cartao")
@Data
public class Cartao {

    @Id
    private String uuid;
    private String nome;

}
