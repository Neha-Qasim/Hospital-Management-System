package javaProject;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HospitalManagementSystem extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent root=FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene=new Scene(root);
        stage.setMinWidth(340);
        stage.setMinHeight(500);
        stage.setTitle("Hospital Management System");
        stage.setScene(scene);
        stage.show();
	}
 
	public static void main(String[] args) {
	     launch(args);

	}

}
