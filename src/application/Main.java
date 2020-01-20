package application;

import java.io.IOException;
import java.util.Locale;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/gui/View.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);

		
	}
	
	public static String calc(double peso, double altura) {
		Locale.setDefault(Locale.US);
		
		Double calc = peso / (altura * altura);
		String imc = String.format("%.2f", calc);

		return imc;
	}
	
	public static String massaCorporal(String peso, String altura) {
		Locale.setDefault(Locale.US);
		String valor;
		double resultMass = Double.parseDouble(Main.calc(Double.parseDouble(peso), Double.parseDouble(altura)));
		if(resultMass < 18.5) 
			valor = "Desnutrição";
		else if(resultMass >= 18.5 && resultMass <= 24.5)
			valor = "Peso Normal";
		else if(resultMass > 24.5 && resultMass <= 29.9)
			valor = "Sobrepeso";
		else if(resultMass >= 30 && resultMass <= 39.9)
			valor = "Obesidade";
		else
			valor = "Obesidade Mórbida";
		
		
		return valor;	
	}
}
