
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class SimpleTableController {
	

	@FXML
	public Button submit;		//button to insert the data to the table
	
	@FXML
	TextField ItemIDtext;		//text field to enter music id 
	
	@FXML
	TextField titletext;		//text field to enter title
	
	@FXML
	TextField Genre;		//text field to enter genre
	
	@FXML
	TextField releasedate;		//text field to enter release date
	
	@FXML
	TextField Artist;		//text field to enter artist name
	
	@FXML
	TextField Price;		//text field to enter price
	
    @FXML
    TableColumn<content, String> ItemIdcol;
    @FXML
    TableColumn<content, String> titlecol;
    @FXML
    TableColumn<content, String> genrecol;
    @FXML													//column id
    TableColumn<content, String> releasecol;
    @FXML
    TableColumn<content, String> artistcol;
    @FXML
    TableColumn<content, String> pricecol;
    
    @FXML
    TableView<content> tblParticipants;

    @FXML
    public void initialize() {

    	ItemIdcol.setCellValueFactory(new PropertyValueFactory<content,String>("ItemId"));
    	titlecol.setCellValueFactory(new PropertyValueFactory<content,String>("title"));
    	genrecol.setCellValueFactory(new PropertyValueFactory<content,String>("genre"));
    	releasecol.setCellValueFactory(new PropertyValueFactory<content,String>("release"));
    	artistcol.setCellValueFactory(new PropertyValueFactory<content,String>("artist"));
    	pricecol.setCellValueFactory(new PropertyValueFactory<content,String>("price"));
    	refresh();
    }

    @FXML
    public void refresh() {

        Task<List<content>> task = new Task<List<content>>() {
            @Override
            protected List<content> call() throws Exception {
                return fetchData();
            }

            @Override
            protected void succeeded() {
                tblParticipants.getItems().clear();
                tblParticipants.getItems().addAll( getValue() );
            }
        };

        new Thread(task).start();
    }

    private List<content> fetchData() {

        List<content> participantList = new ArrayList<>();
        
        try{
			
    		Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/music_player","root","");
    		Statement st = connection.createStatement();
    		st.executeQuery("select * from details ORDER BY title ASC");		//sql command to get the title name in ascending order
    		ResultSet rs = st.getResultSet();		//logical check

    		while(rs.next()){
               
    			participantList.add ( new content(rs.getString("ItemID"),rs.getString("title"),rs.getString("genre"),rs.getString("release_date"),rs.getString("artist"),rs.getString("price")));
    		}
    		
    		}catch (SQLException e) {
    			System.out.println(e);
    		}

        return participantList;
    }
    
public void ADDdetails() throws SQLException{
		
		String ItemIDStr = ItemIDtext.getText();
		String TitleStr = titletext.getText();
		String GenreStr = Genre.getText();			//variable list
		String ReleaseStr = releasedate.getText();
		String ArtistStr = Artist.getText();
		String PriceStr = Price.getText();
		
		Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/music_player","root","");
		Statement st = connection.createStatement();
		
    	
    	
	    String queary = "INSERT INTO  details(ItemID,title,genre,release_date,artist,price) VALUES('"+ItemIDStr+"','"+TitleStr+"','"+GenreStr+"','"+ReleaseStr+"','"+ArtistStr+"','"+PriceStr+"')";
	    									//sql command to insert data
    	
	    int rs = st.executeUpdate(queary);	
		
		System.out.println(rs);
		
		ItemIDtext.setText("");  
		titletext.setText("");
		Genre.setText("");
		releasedate.setText("");
		Artist.setText("");
		Price.setText("");
		refresh();
	}

}

 