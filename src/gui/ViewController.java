package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ViewController implements Initializable {
	
	@FXML
	private Button btcalc;
	@FXML
	private Button btlimp;
	@FXML
	private TextField txtPeso;
	@FXML
	private TextField txtAltura;
	@FXML
	private Label labelResult;
	@FXML
	private Label labelNutri;
	
	
	@FXML
	public void onBtcalcAction() {
		try {
		labelResult.setText(Main.calc(Double.parseDouble(txtPeso.getText()), Double.parseDouble(txtAltura.getText())));
		labelNutri.setText(Main.massaCorporal(txtPeso.getText(), txtAltura.getText()));
		}
		catch(NumberFormatException e) {
			Alerts.showAlert("Campo Obrigatório", "Digite os valores nos campos", e.getMessage(), AlertType.ERROR);
		}
		
	}
	@FXML
	public void onBtlimcAction() {
		txtPeso.setText("");
		txtAltura.setText("");
		labelResult.setText("");
		labelNutri.setText("");
	}
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(txtPeso);
		Constraints.setTextFieldDouble(txtAltura);
		Constraints.setTextFieldMaxLength(txtPeso, 3);
		Constraints.setTextFieldMaxLength(txtAltura, 4);
		
	}

}
