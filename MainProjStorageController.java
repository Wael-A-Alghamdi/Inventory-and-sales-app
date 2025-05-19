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
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asrock
 */
public class MainProjStorageController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private TableView<StorageTableView> table;
    @FXML
    private TableColumn<StorageTableView,String> colItem_Name;
    @FXML
    private TableColumn<StorageTableView,String> colItem_Code;
    @FXML
    private TableColumn<StorageTableView,String> colItem_Quantity;
    @FXML
    private TableColumn<StorageTableView,String> colItem_Price;
    @FXML
    private TableColumn<StorageTableView,Integer> colID;
     ObservableList<StorageTableView> oblist=FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       Storage con = new Storage();

         try {
             
                             con.StorageData(oblist);

             

          }   catch (SQLException ex) {    
            Logger.getLogger(MainProjStorageController.class.getName()).log(Level.SEVERE, null, ex);
        }
            colID.setCellValueFactory(new PropertyValueFactory<>("id"));
            colItem_Name.setCellValueFactory(new PropertyValueFactory<>("item_name"));
            colItem_Code.setCellValueFactory(new PropertyValueFactory<>("item_code"));
            colItem_Quantity.setCellValueFactory(new PropertyValueFactory<>("item_quantity"));
            colItem_Price.setCellValueFactory(new PropertyValueFactory<>("item_price"));
            table.setItems(oblist);
            
            
    }

    @FXML
    private void BackMainPage(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("AdminMainPage.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
}
