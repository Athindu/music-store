package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.*;

public class BuyItem {


    @FXML
    TextField txtItemID;		//text field to enter the id of the music to be bought

    @FXML
    TextField txtQuantity;		//text field to enter the quantity

    @FXML
    Text lblAmount;

    private ObservableList<Price> prices = FXCollections.observableArrayList();

    public void buyItem(){

        PreparedStatement myStatement;
        Connection connection;
        String itemID = txtItemID.getText();
        int quantity = Integer.parseInt(txtQuantity.getText());
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/music_player", "root", "");
            myStatement = connection.prepareStatement("SELECT price FROM details WHERE ItemID = ? LIMIT 1");     //sql command to select price from the user id
            myStatement.setString(1,itemID);
            ResultSet itemPrice = myStatement.executeQuery();
            while (itemPrice.next()){

                prices.add(new Price(itemPrice.getInt("price")));

            }

            for (Price pri:
                    prices) {
                int price = pri.getPrice();
                int total = price * quantity;
                lblAmount.setText("Total Price = " + total);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
