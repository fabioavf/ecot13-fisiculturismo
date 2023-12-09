package br.edu.unifei.ecot13.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.unifei.ecot13.model.Atleta;
import br.edu.unifei.ecot13.model.Bulking;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class AtletaController {

    @FXML
    private TextField insertAcademia;

    @FXML
    private TextField insertAltura;

    @FXML
    private Button insertBtn;

    @FXML
    private TextField insertCPF;

    @FXML
    private MenuButton insertCategoria;

    @FXML
    private TextField insertDieta;

    @FXML
    private TextField insertFase;

    @FXML
    private TextField insertNascimento;

    @FXML
    private TextField insertNome;

    @FXML
    private TextField insertPais;

    @FXML
    private TextField insertPeso;

    @FXML
    private MenuButton insertSexo;

    @FXML
    private TextField removeAcademia;

    @FXML
    private TextField removeAltura;

    @FXML
    private Button removeBtn;

    @FXML
    private MenuButton removeCategoria;

    @FXML
    private TextField removeCpf;

    @FXML
    private TextField removeDieta;

    @FXML
    private TextField removeFase;

    @FXML
    private TextField removeNascimento;

    @FXML
    private TextField removeNome;

    @FXML
    private TextField removePais;

    @FXML
    private TextField removePeso;

    @FXML
    private TextField removeSearch;

    @FXML
    private Button removeSearchBtn;

    @FXML
    private MenuButton removeSexo;

    @FXML
    private TextField updateAcademia;

    @FXML
    private TextField updateAltura;

    @FXML
    private Button updateBtn;

    @FXML
    private MenuButton updateCategoria;

    @FXML
    private TextField updateCpf;

    @FXML
    private TextField updateDieta;

    @FXML
    private TextField updateFase;

    @FXML
    private TextField updateNascimento;

    @FXML
    private TextField updateNome;

    @FXML
    private TextField updatePais;

    @FXML
    private TextField updatePeso;

    @FXML
    private TextField updateSearch;

    @FXML
    private Button updateSearchBtn;

    @FXML
    private MenuButton updateSexo;

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("eleicaoPU");
    private EntityManager em = emf.createEntityManager();
    private Atleta atleta;

    @FXML
    void insertAtleta(ActionEvent event) {

        System.out.println("Hello!");

        if (insertAcademia.getText() == ""
                || insertAltura.getText() == ""
                || insertCPF.getText() == ""
                || insertCategoria.getText() == ""
                || insertDieta.getText() == ""
                || insertFase.getText() == ""
                || insertNascimento.getText() == ""
                || insertNome.getText() == ""
                || insertPais.getText() == ""
                || insertPeso.getText() == ""
                || insertSexo.getText() == "") {
            System.out.println("Campos faltando.");
            return;
        }

        // em.getTransaction().begin();
        atleta = new Atleta(new Bulking());

        atleta.setAcademia(null);
        atleta.setAltura(Float.parseFloat(insertAltura.getText()));
        atleta.setCategoria(null);
        atleta.setCpf(insertCPF.getText());
        atleta.setDieta(null);
        atleta.setFase(null);
        atleta.setNascimento(null);
        atleta.setNome(insertNome.getText());
        atleta.setPaisOrigem(insertPais.getText());
        atleta.setPeso(Float.parseFloat(insertPeso.getText()));
        atleta.setSexo(parseSexo(insertSexo.getText()));

        System.out.println(atleta);

        // em.persist(atleta);
        // em.getTransaction().commit();
    }

    @FXML
    void removeAtleta(ActionEvent event) {

    }

    @FXML
    void searchAtleta(ActionEvent event) {
        System.out.println(event.getSource().toString());
    }

    @FXML
    void updateAtleta(ActionEvent event) {

    }

    char parseSexo(String input) {
        if (input == "Masculino")
            return 'M';
        if (input == "Feminino")
            return 'F';

        return ' ';
    }

}
