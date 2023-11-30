package br.edu.unifei.ecot13.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Proteina extends Macronutriente {
    private String origem;

    public boolean aceitar(Dieta d) {
        return d.visitar(this);
    }
}
