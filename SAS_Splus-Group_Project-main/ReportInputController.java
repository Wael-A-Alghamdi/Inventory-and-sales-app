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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asrock
 */
public class ReportInputController implements Initializable {

    @FXML
    private Button btnBackReport;
    @FXML
    private Button btnReport;
    @FXML
    private TextArea txtContent;
    @FXML
    private TextArea txtTopic;
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
    private void BackReport(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("CashierMainScreen.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Report(ActionEvent event) throws SQLException {
        
        Report u = new Report();
        if((txtTopic.getText().isEmpty()) || (txtContent.getText().isEmpty())){
             lblMassage.setText("✖ Please fill all the blanks");
        }else{
             u.insertReport(txtTopic.getText(), txtContent.getText());
             lblMassage.setText("✔ The Report Send....");
        }
    }
    
}
