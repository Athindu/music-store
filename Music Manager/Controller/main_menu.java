package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class main_menu {
	
	@FXML
	public Button addviewbutton;					//button to insert music
	
	@FXML
	public Button logout;			//exit button
	
	@FXML
	public Button IDdelete;			//button to delete music
	
	@FXML
	public Button sort;          //button to sort music according to title
	
	 public void addView(ActionEvent event) throws Exception {               
         try {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Controller/musicview.fxml"));
                 Parent root1 = (Parent) fxmlLoader.load();
                 Stage stage = new Stage();
                 stage.setScene(new Scene(root1));  
     	         stage.setTitle("Music View Page");

                 stage.show();
		    	 

         } catch(Exception e) {
            e.printStackTrace();
           }
 }
	 
	 public void deleteView(ActionEvent event) throws Exception {               
         try {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Controller/updateDelete.fxml"));
                 Parent root1 = (Parent) fxmlLoader.load();
                 Stage stage = new Stage();
                 stage.setScene(new Scene(root1));  
     	         stage.setTitle("Music View Page");

                 stage.show();
		    	 

         } catch(Exception e) {
            e.printStackTrace();
           }
 }
	 
	 public void sort(ActionEvent event) throws Exception {               
         try {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Controller/sort.fxml"));
                 Parent root1 = (Parent) fxmlLoader.load();
                 Stage stage = new Stage();
                 stage.setScene(new Scene(root1));  
     	         stage.setTitle("Music sort View Page");

                 stage.show();
		    	 

         } catch(Exception e) {
            e.printStackTrace();
           }
	 }

	 public void buyItem(){

         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Controller/buy_item.fxml"));
         try {
             Parent root1 =fxmlLoader.load();
             Stage stage = new Stage();
             stage.setTitle("Buy Items");
             stage.setScene(new Scene(root1));
             stage.show();
         } catch (IOException e) {
             e.printStackTrace();
         }


     }
	 
	 
	 
	 @FXML
     public void exit() {
 	    
 	        System.exit(0);
 	        
 	}
	 

}
