package br.edu.unifei.ecot13.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Gordura extends Macronutriente {
    private boolean saturada;
    private boolean trans;

    public boolean aceitar(Dieta d) {
        return d.visitar(this);
    }
}
