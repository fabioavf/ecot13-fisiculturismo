package br.edu.unifei.ecot13.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Atleta extends Pessoa {
    private float peso;
    private float altura;
    private CategoriaEnum categoria;

    @OneToOne
    private Academia academia;

    @OneToOne
    private Fase fase;

    @OneToOne
    private Dieta dieta;

    public Atleta(Fase fase) {
        this.fase = fase;
    }

    public void comer() {
        System.out.println("Comer!");
    }

    public void treinar() {
        System.out.println("Treinar!");
    }

    public void dormir() {
        System.out.println("Dormir!");
    }

    public void trocarDeFase() {
        fase.trocarDeFase(this);
    }
}
