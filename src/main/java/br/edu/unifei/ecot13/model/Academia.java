package br.edu.unifei.ecot13.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Academia implements Serializable {
    @Id
    private String cnpj;
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date fundacao;
    private String localizacao;
    private float mensalidade;

    @OneToMany
    private List<Treinador> treinadores = new ArrayList<Treinador>();

    @OneToMany
    private List<Equipamento> equipamentos = new ArrayList<Equipamento>();
}
