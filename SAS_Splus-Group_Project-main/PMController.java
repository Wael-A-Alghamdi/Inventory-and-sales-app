/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author asrock
 */
public class PMController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private ComboBox<?> cbSelect;
    @FXML
    private BorderPane Bpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void BackMainPage(ActionEvent event) {
        
    }

    @FXML
    private void Select1(ActionEvent event) {
    }
    
}
