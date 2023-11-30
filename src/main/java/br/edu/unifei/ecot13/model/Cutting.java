package br.edu.unifei.ecot13.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Cutting extends Fase {
    public void trocarDeFase(Atleta a) {
        a.setFase(new Bulking());
    }
}
