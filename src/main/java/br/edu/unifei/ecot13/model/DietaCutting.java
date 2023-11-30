package br.edu.unifei.ecot13.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class DietaCutting extends Dieta {
    public boolean visitar(Carboidrato c) {
        if (c.isAcucar()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean visitar(Proteina p) {
        return true;
    }

    public boolean visitar(Gordura g) {
        return false;
    }
}