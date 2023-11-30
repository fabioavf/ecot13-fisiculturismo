package br.edu.unifei.ecot13.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public abstract class Dieta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int totalCalorias;

    @ManyToMany
    private List<Macronutriente> alimentos = new ArrayList<Macronutriente>();

    public void setAlimentos(List<Macronutriente> alimentos) {
        List<Macronutriente> tempList = new ArrayList<Macronutriente>();

        for (Macronutriente alimento : alimentos) {
            if (alimento.aceitar(this)) {
                tempList.add(alimento);
            }
        }

        this.alimentos = tempList;
    }

    public abstract boolean visitar(Carboidrato c);

    public abstract boolean visitar(Proteina p);

    public abstract boolean visitar(Gordura g);

    public int calcularCalorias() {
        int sum = 0;

        for (Macronutriente a : getAlimentos()) {
            switch (a.getClass().getSimpleName()) {
                case "Carboidrato":
                    sum += a.getQuantidade() * 4;
                    break;
                case "Proteina":
                    sum += a.getQuantidade() * 4;
                    break;
                case "Gordura":
                    sum += a.getQuantidade() * 9;
                    break;
                default:
                    break;
            }
        }

        return sum;
    }
}
