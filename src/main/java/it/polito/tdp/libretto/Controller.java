package it.polito.tdp.libretto;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.polito.tdp.libretto.model.Libretto;
import it.polito.tdp.libretto.model.Voto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;


public class Controller {
	
	Libretto model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnInserisci;

    @FXML
    private ComboBox<Integer> cmbPunti;

    @FXML
    private DatePicker setData;

    @FXML
    private TextField txtCorso;

    @FXML
    private TextArea txtRisultato;
    
    @FXML
    void initialize(ActionEvent event) {
    	
    	String corso = this.txtCorso.getText();
    	Integer punti = this.cmbPunti.getValue();
    	LocalDate data = this.setData.getValue();
    	
    	Voto nuovo = new Voto(corso, punti, data);
    	if(model.isConflitto(nuovo)) {
    		this.txtRisultato.setText("Voto non valido!!!");
    		return;}
    	model.addV2(nuovo);
    	this.txtRisultato.setText(model.toString());
    	this.txtCorso.clear();
    	this.cmbPunti.setValue(0);
    	this.setData.setValue(null);
    	
    }
    
   
    
    @FXML
    void initialize() {
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'main.fxml'.";
        assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'main.fxml'.";
        assert setData != null : "fx:id=\"setData\" was not injected: check your FXML file 'main.fxml'.";
        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'main.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'main.fxml'.";
        
        for(int i=18; i<=30; i++) {
        	cmbPunti.getItems().add(i);
        }
    }
    
    public void setModel(Libretto model) {
    	this.model=model;
    }
}

