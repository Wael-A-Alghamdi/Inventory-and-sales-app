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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author S0osa
 */
public class AdminMainPageController implements Initializable {

    @FXML
    private ComboBox<String> btnComb;
    @FXML
    private Button btnAdminLogout;
    @FXML
    private Button btnShowReports;
    @FXML
    private TableView<StorageTableView> table;
    @FXML
    private TableColumn<StorageTableView, String> colItem_Name;
    @FXML
    private TableColumn<StorageTableView, String> colItem_Code;
    @FXML
    private TableColumn<StorageTableView, String> colItem_Quantity;
    @FXML
    private TableColumn<StorageTableView, String> colItem_Price;
    @FXML
    private TableColumn<StorageTableView, Integer> colID;
     ObservableList<StorageTableView> oblist = FXCollections.observableArrayList();
    @FXML
    private Button btnRefresh;
    @FXML
    private Button btnAddCashers;
    @FXML
    private TextField txtItemCode;
    @FXML
    private Button btnSearch;
    
    @FXML
    private Button btnDelete;
    @FXML
    private BorderPane BPaneUpdate;
    @FXML
    private TextField txtItemNameUpdare;
    @FXML
    private TextField txtItemCodeUpdate;
    @FXML
    private TextField txtItemQuantityUpdate;
    @FXML
    private TextField txtItemPriceUpdate;
    @FXML
    private BorderPane BPaneAdd;
    @FXML
    private TextField txtItemNameAdd;
    @FXML
    private TextField txtItemCodeAdd;
    @FXML
    private TextField txtItemQuantityAdd;
    @FXML
    private TextField txtItemPriceAdd;
    @FXML
    private Label lblMassageUpdate;
    @FXML
    private Label lblMassageAdd;
    @FXML
    private Button btnUpdate;

    int id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Update Item", "Add Item");
        btnComb.setItems(list);
         BPaneUpdate.setVisible(true);
                BPaneAdd.setVisible(false);
                
        Storage con = new Storage();

        try {

            con.StorageData(oblist);

        } catch (SQLException ex) {
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
    private void Select(ActionEvent event) throws IOException {
        String s = btnComb.getSelectionModel().getSelectedItem().toString();
              
        if (s.equals("Update Item")) {
           
                                BPaneUpdate.setVisible(true);

                BPaneAdd.setVisible(false);
        } else if (s.equals("Add Item")) {
             BPaneUpdate.setVisible(false);

                BPaneAdd.setVisible(true);
        }
    }

    @FXML
    private void AdminLogout(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("SignInMain.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void ShowReports(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("ReportShow.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private void Refresh(ActionEvent event) throws SQLException {
                Storage u = new Storage();
                u.StorageData(oblist);

    }

    @FXML
    private void AddCashers(ActionEvent event) throws IOException {
     
        Parent root = FXMLLoader.load(getClass().getResource("InsertCashers.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Search(ActionEvent event) throws SQLException {
        table.getItems().clear();
        Storage con = new Storage();
        con.SearchStorage(oblist,txtItemCode.getText());
         colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colItem_Name.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        colItem_Code.setCellValueFactory(new PropertyValueFactory<>("item_code"));
        colItem_Quantity.setCellValueFactory(new PropertyValueFactory<>("item_quantity"));
        colItem_Price.setCellValueFactory(new PropertyValueFactory<>("item_price"));
        table.setItems(oblist);
    }

    @FXML
    private void Delete(ActionEvent event) throws SQLException {
        Storage con = new Storage();
       
        int des = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this item?", "Delete Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (des == 0) {
            StorageTableView selectedItem = table.getSelectionModel().getSelectedItem();
            con.DeleteItem(selectedItem.getItem_code());
            table.refresh();
            table.getItems().clear();
            table.setItems(oblist);
            con.StorageData(oblist);
              colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colItem_Name.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        colItem_Code.setCellValueFactory(new PropertyValueFactory<>("item_code"));
        colItem_Quantity.setCellValueFactory(new PropertyValueFactory<>("item_quantity"));
        colItem_Price.setCellValueFactory(new PropertyValueFactory<>("item_price"));
        table.setItems(oblist);
        }

    
    }

    @FXML
    private void AddItem(ActionEvent event) throws SQLException {
                Storage u = new Storage();
        if(txtItemNameAdd.getText().isEmpty() || txtItemCodeAdd.getText().isEmpty() || txtItemQuantityAdd.getText().isEmpty() || txtItemPriceAdd.getText().isEmpty()){
             lblMassageAdd.setText("✖ Please fill all the blanks");
        }else{
        u.insertItem(txtItemNameAdd.getText(),txtItemCodeAdd.getText(),txtItemQuantityAdd.getText(),Double.valueOf(txtItemPriceAdd.getText()));
         u.StorageData(oblist);
         lblMassageAdd.setText("✔ Item added....");
        }
    }

    @FXML
    private void UpdateItem(ActionEvent event) throws SQLException {
                   Storage con = new Storage();

      
       con.updateItem(txtItemNameUpdare.getText(),txtItemCodeUpdate.getText(),Integer.parseInt(txtItemQuantityUpdate.getText()),Double.valueOf(txtItemPriceUpdate.getText()),id);
         table.getItems().clear();
            table.setItems(oblist);
            con.StorageData(oblist);
                   colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colItem_Name.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        colItem_Code.setCellValueFactory(new PropertyValueFactory<>("item_code"));
        colItem_Quantity.setCellValueFactory(new PropertyValueFactory<>("item_quantity"));
        colItem_Price.setCellValueFactory(new PropertyValueFactory<>("item_price"));
        table.setItems(oblist);
           
    }

    @FXML
    private void Update(ActionEvent event) throws SQLException {
           Storage con = new Storage();
        StorageTableView selectedItem = table.getSelectionModel().getSelectedItem();
        txtItemNameUpdare.setText(selectedItem.getItem_name());
        txtItemCodeUpdate.setText(selectedItem.getItem_code());
                txtItemQuantityUpdate.setText(String.valueOf(selectedItem.getItem_quantity()));
        txtItemPriceUpdate.setText(String.valueOf(selectedItem.getItem_price()));

         id = con.getId(selectedItem.getItem_code());
        System.out.println("id="+id);
    }

}
