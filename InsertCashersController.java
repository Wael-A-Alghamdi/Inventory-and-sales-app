/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asrock
 */
public class InsertCashersController implements Initializable {

   
    @FXML
    private Button btnBack;
    @FXML
    private Button btnSave;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPhone_number;
    @FXML
    private TextField txtUser_id;
    @FXML
    private TextField txtPassword;
    @FXML
    private Label lblMassage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Back(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("AdminMainPage.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Save(ActionEvent event) throws SQLException {
        Cashers u = new Cashers();

        
      
        if((txtName.getText().isEmpty()) || (txtPhone_number.getText().isEmpty())|| (txtUser_id.getText().isEmpty()) || (txtPassword.getText().isEmpty())){
             lblMassage.setText("✖ Please fill all the blanks");
        }else{
             u.insertCasher(txtName.getText(), txtPhone_number.getText(), txtUser_id.getText(), txtPassword.getText());
             lblMassage.setText("✔ Casher Added...");
        }
    }
    
}
