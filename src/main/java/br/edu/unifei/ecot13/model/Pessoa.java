package br.edu.unifei.ecot13.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public abstract class Pessoa implements Serializable {
    @Id
    private String cpf;
    private String nome;

    @Temporal(TemporalType.DATE)
    private Date nascimento;
    private char sexo;
    private String paisOrigem;
}
