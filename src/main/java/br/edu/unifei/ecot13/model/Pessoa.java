package br.edu.unifei.ecot13.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public abstract class Pessoa implements Serializable {
    @Id
    private String cpf;
    private String nome;

    private Date nascimento;
    private char sexo;
    private String paisOrigem;
}
