package Controller;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launch extends Application{

	  public void start(Stage stage) throws Exception {
	        Parent root = FXMLLoader.load(getClass().getResource("../Controller/main_menu.fxml"));  //getting the main menu interface
	        
	        Scene scene = new Scene(root);        
	        stage.setScene(scene);
	        stage.setTitle("Main menu");				
	        stage.show();
	  }

	  
	    public static void main(String args[]){
	    	launch(args);
	    }
}
