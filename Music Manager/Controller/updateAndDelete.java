package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;

public class updateAndDelete {
	String selection = null;

	@FXML
	public Button delete;		
	
	@FXML
	TextField IDtextdelete;		//text field to insert the id of the music item
	
	
	
public void Empdelete() throws SQLException{
		
		String ItemId = IDtextdelete.getText();			//set it into a variable
		
		
		Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/music_player","root","");
		Statement st = connection.createStatement();
		
    	
    	
	    String queary = "DELETE FROM  details WHERE ItemID='"+ItemId+"'";		//sql code to delete music from database
	    

    	
	    int rs = st.executeUpdate(queary);
	    
	    if(rs==0){
	         Alert message = new Alert(Alert.AlertType.INFORMATION);	
	         message.setHeaderText("Invalid Input");								//error handle for non existing music item
	         message.setContentText("Employee Id is not in the music list !!!");
	         message.show();
	     }
		
		System.out.println(rs);
		
		IDtextdelete.setText("");  
		
	}


}
