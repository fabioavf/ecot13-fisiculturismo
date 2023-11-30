package br.edu.unifei.ecot13.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Campeonato implements Serializable {
    @Id
    private String name;
    private int edicao;

    @OneToMany
    private List<Atleta> atletas = new ArrayList<Atleta>();

    @OneToMany
    private List<Arbitro> arbitros = new ArrayList<Arbitro>();
}
