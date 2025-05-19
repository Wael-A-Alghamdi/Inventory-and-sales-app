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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asrock
 */
public class SignInMainController implements Initializable {

    @FXML
    private Button btnSignIn;
    @FXML
    private Button btnAdminLogin;
    @FXML
    private TextField txtId;
    @FXML
    private PasswordField txtPassword;
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
    private void Signin(ActionEvent event) throws IOException, SQLException {
         
        Admins ObjA = new Admins();
        boolean signinA = ObjA.loginAdmin(txtId.getText() , txtPassword.getText());
        Cashers ObjC = new Cashers();
        boolean signinC = ObjC.loginCasher(txtId.getText() , txtPassword.getText());
        if(signinC){
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("CashierMainScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
        }else if (signinA){
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("CashierMainScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
           
        }else{
            lblMassage.setText("Wrong username or password");
             System.out.println("Wrong username or password");
        }
    }

    @FXML
    private void AdminLogin(ActionEvent event) throws IOException {
                ((Node)event.getSource()).getScene().getWindow().hide();
      Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
}
 