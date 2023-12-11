package br.edu.unifei.ecot13.controller;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.unifei.ecot13.model.Academia;
import br.edu.unifei.ecot13.model.Atleta;
import br.edu.unifei.ecot13.model.Bulking;
import br.edu.unifei.ecot13.model.CategoriaEnum;
import br.edu.unifei.ecot13.model.Dieta;
import br.edu.unifei.ecot13.model.Fase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class AtletaController implements Initializable {

    /* ---------------------------- Insert Fields --------------------------- */

    @FXML
    private ChoiceBox<Academia> insertAcademia;

    @FXML
    private TextField insertAltura;

    @FXML
    private Button insertBtn;

    @FXML
    private TextField insertCPF;

    @FXML
    private ChoiceBox<CategoriaEnum> insertCategoria;

    @FXML
    private ChoiceBox<Dieta> insertDieta;

    @FXML
    private ChoiceBox<Fase> insertFase;

    @FXML
    private DatePicker insertNascimento;

    @FXML
    private TextField insertNome;

    @FXML
    private TextField insertPais;

    @FXML
    private TextField insertPeso;

    @FXML
    private ChoiceBox<Character> insertSexo;

    /* ---------------------------- Update Fields --------------------------- */

    @FXML
    private ChoiceBox<Academia> updateAcademia;

    @FXML
    private TextField updateAltura;

    @FXML
    private Button updateBtn;

    @FXML
    private ChoiceBox<CategoriaEnum> updateCategoria;

    @FXML
    private TextField updateCpf;

    @FXML
    private ChoiceBox<Dieta> updateDieta;

    @FXML
    private ChoiceBox<Fase> updateFase;

    @FXML
    private DatePicker updateNascimento;

    @FXML
    private TextField updateNome;

    @FXML
    private TextField updatePais;

    @FXML
    private TextField updatePeso;

    @FXML
    private ChoiceBox<Atleta> updateSearch = new ChoiceBox<Atleta>();

    @FXML
    private Button updateSearchBtn;

    @FXML
    private ChoiceBox<Character> updateSexo;

    /* ---------------------------- Remove Fields --------------------------- */

    @FXML
    private ChoiceBox<Academia> removeAcademia;

    @FXML
    private TextField removeAltura;

    @FXML
    private Button removeBtn;

    @FXML
    private ChoiceBox<CategoriaEnum> removeCategoria;

    @FXML
    private TextField removeCpf;

    @FXML
    private ChoiceBox<Dieta> removeDieta;

    @FXML
    private ChoiceBox<Fase> removeFase;

    @FXML
    private DatePicker removeNascimento;

    @FXML
    private TextField removeNome;

    @FXML
    private TextField removePais;

    @FXML
    private TextField removePeso;

    @FXML
    private ChoiceBox<Atleta> removeSearch = new ChoiceBox<Atleta>();

    @FXML
    private Button removeSearchBtn;

    @FXML
    private ChoiceBox<Character> removeSexo;

    /* ------------------------- Logic and Functions ------------------------ */

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("fisiculturismoPU");
    private EntityManager em = emf.createEntityManager();
    private Atleta atleta;

    /* ----------------------------- General Use ---------------------------- */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        insertCategoria.getItems().addAll(CategoriaEnum.values());
        updateCategoria.getItems().addAll(CategoriaEnum.values());
        removeCategoria.getItems().addAll(CategoriaEnum.values());

        insertSexo.getItems().addAll('M', 'F');
        updateSexo.getItems().addAll('M', 'F');
        removeSexo.getItems().addAll('M', 'F');

        List<Academia> academias = em.createQuery("from Academia a").getResultList();
        insertAcademia.getItems().addAll(academias);
        updateAcademia.getItems().addAll(academias);
        removeAcademia.getItems().addAll(academias);

        List<Dieta> dietas = em.createQuery("from Dieta d").getResultList();
        insertDieta.getItems().addAll(dietas);
        updateDieta.getItems().addAll(dietas);
        removeDieta.getItems().addAll(dietas);

        List<Fase> fases = em.createQuery("from Fase f").getResultList();
        insertFase.getItems().addAll(fases);
        updateFase.getItems().addAll(fases);
        removeFase.getItems().addAll(fases);

        refreshQueries();
    }

    @FXML
    void refreshQueries() {
        ObservableList<Atleta> atletas = FXCollections.observableList(em.createQuery("from Atleta a").getResultList());
        updateSearch.setItems(atletas);
        removeSearch.setItems(atletas);
    }

    @FXML
    void searchAtleta(ActionEvent event) {
        if (event.getSource().toString().contains("updateSearchBtn")) {
            if (updateSearch.getValue() == null)
                return;

            atleta = updateSearch.getValue();

            updateAcademia.setValue(atleta.getAcademia());
            updateCategoria.setValue(atleta.getCategoria());
            updateDieta.setValue(atleta.getDieta());
            updateFase.setValue(atleta.getFase());

            updateAltura.setText(Float.toString(atleta.getAltura()));
            updateCpf.setText(atleta.getCpf());
            updateNome.setText(atleta.getNome());
            updatePais.setText(atleta.getPaisOrigem());
            updateSexo.setValue(atleta.getSexo());
            updatePeso.setText(Float.toString(atleta.getPeso()));

            updateNascimento.setValue(atleta.getNascimento().toLocalDate());

            updateAcademia.setDisable(false);
            updateCategoria.setDisable(false);
            updateDieta.setDisable(false);
            updateFase.setDisable(false);
            updateAltura.setDisable(false);
            // updateCpf.setDisable(false);
            updateNome.setDisable(false);
            updatePais.setDisable(false);
            updateSexo.setDisable(false);
            updatePeso.setDisable(false);
            updateNascimento.setDisable(false);

            updateBtn.setDisable(false);

            return;
        }

        if (removeSearch.getValue() == null)
            return;

        atleta = removeSearch.getValue();

        removeAcademia.setValue(atleta.getAcademia());
        removeCategoria.setValue(atleta.getCategoria());
        removeDieta.setValue(atleta.getDieta());
        removeFase.setValue(atleta.getFase());

        removeAltura.setText(Float.toString(atleta.getAltura()));
        removeCpf.setText(atleta.getCpf());
        removeNome.setText(atleta.getNome());
        removePais.setText(atleta.getPaisOrigem());
        removeSexo.setValue(atleta.getSexo());
        removePeso.setText(Float.toString(atleta.getPeso()));

        removeNascimento.setValue(atleta.getNascimento().toLocalDate());

        removeBtn.setDisable(false);

        return;
    }

    /* ------------------------------- Insert ------------------------------- */

    @FXML
    void insertAtleta(ActionEvent event) {
        if (insertAcademia.getValue() == null
                || insertAltura.getText() == null || insertAltura.getText().isEmpty()
                || insertCPF.getText() == null || insertCPF.getText().isEmpty()
                || insertCategoria.getValue() == null
                || insertDieta.getValue() == null
                || insertFase.getValue() == null
                || insertNascimento.getValue() == null
                || insertNome.getText() == null || insertNome.getText().isEmpty()
                || insertPais.getText() == null || insertPais.getText().isEmpty()
                || insertPeso.getText() == null || insertPeso.getText().isEmpty()
                || insertSexo.getValue() == null) {
            System.out.println("Campos faltando.");
            return;
        }

        em.getTransaction().begin();
        atleta = new Atleta(new Bulking());

        atleta.setAcademia(insertAcademia.getValue());
        atleta.setAltura(Float.parseFloat(insertAltura.getText()));
        atleta.setCategoria(insertCategoria.getValue());
        atleta.setCpf(insertCPF.getText());
        atleta.setDieta(insertDieta.getValue());
        atleta.setFase(insertFase.getValue());
        atleta.setNascimento(Date.valueOf(insertNascimento.getValue()));
        atleta.setNome(insertNome.getText());
        atleta.setPaisOrigem(insertPais.getText());
        atleta.setPeso(Float.parseFloat(insertPeso.getText()));
        atleta.setSexo(insertSexo.getValue());

        em.persist(atleta);
        em.getTransaction().commit();

        insertAcademia.setValue(null);
        insertCategoria.setValue(null);
        insertDieta.setValue(null);
        insertFase.setValue(null);
        insertAltura.setText(null);
        insertCPF.setText(null);
        insertNome.setText(null);
        insertPais.setText(null);
        insertSexo.setValue(null);
        insertPeso.setText(null);
    }

    /* ------------------------------- Update ------------------------------- */

    @FXML
    void updateAtleta(ActionEvent event) {
        em.getTransaction().begin();

        atleta.setAcademia(updateAcademia.getValue());
        atleta.setAltura(Float.parseFloat(updateAltura.getText()));
        atleta.setCategoria(updateCategoria.getValue());
        atleta.setCpf(updateCpf.getText());
        atleta.setDieta(updateDieta.getValue());
        atleta.setFase(updateFase.getValue());
        atleta.setNascimento(Date.valueOf(updateNascimento.getValue()));
        atleta.setNome(updateNome.getText());
        atleta.setPaisOrigem(updatePais.getText());
        atleta.setPeso(Float.parseFloat(updatePeso.getText()));
        atleta.setSexo(updateSexo.getValue());

        em.merge(atleta);
        em.getTransaction().commit();

        updateAcademia.setValue(null);
        updateCategoria.setValue(null);
        updateDieta.setValue(null);
        updateFase.setValue(null);
        updateAltura.setText(null);
        updateCpf.setText(null);
        updateNome.setText(null);
        updatePais.setText(null);
        updateSexo.setValue(null);
        updatePeso.setText(null);
        updateSearch.setValue(null);
        refreshQueries();
    }

    /* ------------------------------- Remove ------------------------------- */

    @FXML
    void removeAtleta(ActionEvent event) {
        atleta = em.find(Atleta.class, removeCpf.getText());

        if (atleta != null) {
            em.getTransaction().begin();
            em.remove(atleta);
            em.getTransaction().commit();
        }

        removeAcademia.setValue(null);
        removeCategoria.setValue(null);
        removeDieta.setValue(null);
        removeFase.setValue(null);
        removeAltura.setText(null);
        removeCpf.setText(null);
        removeNome.setText(null);
        removePais.setText(null);
        removeSexo.setValue(null);
        removePeso.setText(null);
        removeSearch.setValue(null);

        refreshQueries();
    }
}
