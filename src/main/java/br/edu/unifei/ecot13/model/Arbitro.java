package br.edu.unifei.ecot13.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Arbitro extends Pessoa {
    private int cadastro;
}
