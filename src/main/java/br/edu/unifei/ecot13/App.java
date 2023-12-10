package br.edu.unifei.ecot13;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.unifei.ecot13.model.Academia;
import br.edu.unifei.ecot13.model.Atleta;
import br.edu.unifei.ecot13.model.Bulking;
import br.edu.unifei.ecot13.model.Carboidrato;
import br.edu.unifei.ecot13.model.CategoriaEnum;
import br.edu.unifei.ecot13.model.DietaBulking;
import br.edu.unifei.ecot13.model.DietaCutting;
import br.edu.unifei.ecot13.model.Gordura;
import br.edu.unifei.ecot13.model.Proteina;

public class App {
    public static void main(String[] args) {
        GUIStarter.main(args);
    }
}
