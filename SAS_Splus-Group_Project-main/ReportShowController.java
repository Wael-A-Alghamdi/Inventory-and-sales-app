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
public class ReportShowController implements Initializable {

    @FXML
    private TableColumn<ReportTableView, String> colTopic;
    @FXML
    private TableColumn<ReportTableView, String> colContent;
    ObservableList<ReportTableView> oblist=FXCollections.observableArrayList();
    @FXML
    private TableView<ReportTableView> cbReport;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         Report con = new Report();

         try {
            con.ReportData(oblist);

        } catch (SQLException ex) {
            Logger.getLogger(ReportShowController.class.getName()).log(Level.SEVERE, null, ex);
        }
         colTopic.setCellValueFactory(new PropertyValueFactory<>("topic"));
        colContent.setCellValueFactory(new PropertyValueFactory<>("content"));
        cbReport.setItems(oblist);
        // TODO
    }    

    private void BackReport(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("AdminMainPage.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
}
