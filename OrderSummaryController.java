/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author S0osa
 */
public class OrderSummaryController implements Initializable {

    @FXML
    private Label lblSubtotal;
    @FXML
    private Label lblChange;
    @FXML
    private Label lblVAT;
    @FXML
    private Label lblTotal;
     @FXML   
    private TableView<OrderDetailsTableView> tblDown;
    @FXML
    private TableColumn<OrderDetailsTableView, Integer> colItem_quantity;
    @FXML
    private TableColumn<OrderDetailsTableView, String> colItem_name;
    @FXML
    private TableColumn<OrderDetailsTableView, Double> colItem_price;
    @FXML
    private TableColumn<OrderDetailsTableView, String> colOrder_no;
     ObservableList<OrderDetailsTableView> oblist = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         OrderArr oa=new OrderArr();
         PaymentMethodCashController PaymentMethodCash=new PaymentMethodCashController();
          String s= String.valueOf(oa.sum());
            lblSubtotal.setText(s);
            String t= String.valueOf(oa.sumTotal());
            lblTotal.setText(t);
            lblVAT.setText("15%");
                   

          
             try {
                 OrderNum on=new OrderNum();
                  ArrayList<String> onnum = new ArrayList<String>();
        
          onnum=on.getOrderNumber();
        tblDown.getItems().clear();
        Order con = new Order();
            con.SearchOrderD(oblist,onnum.get(onnum.size()-1));
             colOrder_no.setCellValueFactory(new PropertyValueFactory<>("order_no"));
        colItem_name.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        colItem_quantity.setCellValueFactory(new PropertyValueFactory<>("item_quantity"));
        colItem_price.setCellValueFactory(new PropertyValueFactory<>("item_price"));
        //tblUsers.getItems().clear();
        tblDown.setItems(oblist);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentMethodController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void MainPage(ActionEvent event) throws IOException {
         ((Node)event.getSource()).getScene().getWindow().hide();

          Parent root = FXMLLoader.load(getClass().getResource("CashierMainScreen.fxml"));   
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
}
