package br.edu.unifei.ecot13.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Treinador extends Pessoa {
    private String formacao;

    @Temporal(TemporalType.DATE)
    private Date dataDeGraduacao;
}
