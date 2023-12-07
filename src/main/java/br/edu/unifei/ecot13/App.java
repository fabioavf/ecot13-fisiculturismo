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
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fisiculturismoPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        // Setup atleta
        Atleta atleta = new Atleta(new Bulking());
        atleta.setNome("Fulano");
        atleta.setCpf("100-200-300-40");
        atleta.setSexo('m');
        atleta.setPeso(90);
        atleta.setAltura(135);
        atleta.setCategoria(CategoriaEnum.MENS_CLASSIC);

        Academia academia = new Academia();
        academia.setNome("CT do Fulano");
        academia.setCnpj("10.200.300/0001-4");

        // Setup alimentos
        Carboidrato arroz = new Carboidrato();
        arroz.setAcucar(false);
        arroz.setQuantidade(8 * atleta.getPeso());

        Carboidrato mel = new Carboidrato();
        mel.setAcucar(true);
        mel.setQuantidade(30);

        Proteina frango = new Proteina();
        frango.setOrigem("animal");
        frango.setQuantidade(2 * atleta.getPeso());

        Gordura azeite = new Gordura();
        azeite.setQuantidade(0.4f * atleta.getPeso());

        // Dietas
        DietaBulking dietaBulking = new DietaBulking();
        dietaBulking.setAlimentos(Arrays.asList(arroz, mel, frango, azeite));

        DietaCutting dietaCutting = new DietaCutting();
        dietaCutting.setAlimentos(Arrays.asList(arroz, mel, frango, azeite));

        atleta.trocarDeFase();

        entityManager.persist(arroz);
        entityManager.persist(mel);
        entityManager.persist(frango);
        entityManager.persist(azeite);
        entityManager.persist(dietaBulking);
        // entityManager.persist(dietaCutting);

        entityManager.persist(academia);
        entityManager.persist(atleta.getFase());
        entityManager.persist(atleta);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        GUIStarter.main(args);
    }
}
