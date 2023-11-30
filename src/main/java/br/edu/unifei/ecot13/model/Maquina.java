package br.edu.unifei.ecot13.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Maquina extends Equipamento {
    private String nome;
    private String musculoAlvo;
    private int capacidadeMax;
    private int pesoAtual;
}
