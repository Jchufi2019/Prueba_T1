package application;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControlRocket {
	/**
	 *
	 * @author juanc
	 *
	 */
	
	@FXML
	private AnchorPane Principal, rootHome;  
	@FXML
	private ImageView fotoIni; // variable declarada de tipo @fxml que se utiliza en scenbuilder

	public void initialize() {

		transiccionF();

	}
	// Metodo para abrir una ventana nueva
	 
	@FXML	
	public void openStage() {
		Stage thisStage = (Stage) Principal.getScene().getWindow();
		thisStage.close();
		
		try {
			// Load the fxml file and create a new stage for the popup.
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Urano.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			Scene scene = new Scene(root, 600, 500);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 // Metodo para cerrar la aplicacion
	 
	@FXML
	public void closeApp() {
		Stage thisStage = (Stage) rootHome.getScene().getWindow();
		thisStage.close();
	}
	

	
	
	 // Metodo que se encarga de la transiccion de la foto principal
	 
	
		private void transiccionF() { 
			FadeTransition ft = new FadeTransition(Duration.seconds(5), fotoIni); // declarado arriba
			ft.setFromValue(0);
			ft.setToValue(1);
			ft.play();
		}


	}
