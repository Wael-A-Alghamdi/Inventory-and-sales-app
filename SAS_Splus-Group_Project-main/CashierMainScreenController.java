/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author S0osa
 */
public class CashierMainScreenController implements Initializable {

    @FXML
    private Button btnLogout;
    @FXML
    private Button btnScan;
    @FXML
    private Button btnNextItem;
    @FXML
    private Button btnCheckout;
    @FXML
    private Button btnReport;
    @FXML
    private TextField txtItemCode;
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
    @FXML
    private Label lblSubtotal;
    @FXML
    private Label lblVAT;
    @FXML
    private Label lblTotal;
    @FXML
    private Label lblMassage;
    @FXML
    private TextField txtItemQuantity;
    
    int id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                OrderArr oa=new OrderArr();

         String s= String.valueOf(oa.sum());
            lblSubtotal.setText(s);
            String t= String.valueOf(oa.sumTotal());
            lblTotal.setText(t);
        lblVAT.setText("15%");

    }    

   

    @FXML
    private void Logout(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("SignInMain.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Report(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("ReportInput.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Checkout(ActionEvent event) throws IOException, SQLException {
          Storage u=new Storage();
          Order o=new Order();
         boolean a= u.ScaneItems(txtItemCode.getText());
           o.SelectOrder();
           if(a){
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("PaymentMethod.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
           }else{
                lblMassage.setText("✖ Please Scan item");
           }
               
    }

    @FXML
    private void ScanCode(ActionEvent event) throws SQLException {
        Storage u=new Storage();
        Order o=new Order();
        OrderArr oa=new OrderArr();
         OrderNum on=new OrderNum();
        
       
        
       boolean a= u.ScaneItems(txtItemCode.getText());
           o.SelectOrder();

        if(a){
          ArrayList<String> onnum = new ArrayList<String>();
          ArrayList<String> oaname = new ArrayList<String>();
          ArrayList<Double> oaprice = new ArrayList<Double>();
           onnum=on.getOrderNumber();
           oaname=oa.getName();
            oaprice=oa.getPrice();
            o.insertOrderD(onnum.get(onnum.size()-1),oaname.get(oaname.size()-1),1,oaprice.get(oaprice.size()-1));
            
            int qun=u.SelectStorage(txtItemCode.getText());
            u.UpdateQun((qun-1), txtItemCode.getText());
      
            String s= String.valueOf(oa.sum());
            lblSubtotal.setText(s);
            String t= String.valueOf(oa.sumTotal());
            lblTotal.setText(t);
           
            
           
        tblDown.getItems().clear();
        Order con = new Order();
        con.SearchOrderD(oblist,onnum.get(onnum.size()-1));
                colOrder_no.setCellValueFactory(new PropertyValueFactory<>("order_no"));
        colItem_name.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        colItem_quantity.setCellValueFactory(new PropertyValueFactory<>("item_quantity"));
        colItem_price.setCellValueFactory(new PropertyValueFactory<>("item_price"));
        //tblUsers.getItems().clear();
        tblDown.setItems(oblist);
                   lblMassage.setText("✔ Item Scanned");

        
        }else{
            lblMassage.setText("✖ Wrong Code");
           
        }
        
        
              
        
    }

    @FXML
    private void NextCustomer(ActionEvent event) throws SQLException {
          Order u=new Order();
         
           u.insertOrder();
           lblMassage.setText("Next Customer");
    }

    @FXML
    private void CancleOrder(ActionEvent event) {
         OrderArr a=new OrderArr();
        a.Clear();
    }

    @FXML
    private void ApplyQuantity(ActionEvent event) throws SQLException {
                Storage u=new Storage();

                Order con = new Order();
                         OrderNum on=new OrderNum();

  ArrayList<String> onnum = new ArrayList<String>();
        
          onnum=on.getOrderNumber();
       con.updateQuantity(Integer.parseInt(txtItemQuantity.getText()),id);
       
                int qun=u.SelectStorage(txtItemCode.getText());
            u.UpdateQun((qun-(Integer.parseInt(txtItemQuantity.getText())))+1, txtItemCode.getText());

            
        tblDown.getItems().clear();
      
        con.SearchOrderD(oblist,onnum.get(onnum.size()-1));
                colOrder_no.setCellValueFactory(new PropertyValueFactory<>("order_no"));
        colItem_name.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        colItem_quantity.setCellValueFactory(new PropertyValueFactory<>("item_quantity"));
        colItem_price.setCellValueFactory(new PropertyValueFactory<>("item_price"));
        //tblUsers.getItems().clear();
        tblDown.setItems(oblist);
    }

    @FXML
    private void ChangeQuantity(ActionEvent event) throws SQLException {
            Order con = new Order();
        OrderDetailsTableView selectedItem = tblDown.getSelectionModel().getSelectedItem();
        
      
                txtItemQuantity.setText(String.valueOf(selectedItem.getItem_quantity()));

         id = con.getId(selectedItem.getItem_name());
        System.out.println("id="+id);
    }

    @FXML
    private void Show(ActionEvent event) throws SQLException {
       Order con = new Order();
                         OrderNum on=new OrderNum();

  ArrayList<String> onnum = new ArrayList<String>();
        
          onnum=on.getOrderNumber();
         tblDown.getItems().clear();
         
            tblDown.setItems(oblist);
            con.SearchOrderD(oblist,onnum.get(onnum.size()-1));
                colOrder_no.setCellValueFactory(new PropertyValueFactory<>("order_no"));
        colItem_name.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        colItem_quantity.setCellValueFactory(new PropertyValueFactory<>("item_quantity"));
        colItem_price.setCellValueFactory(new PropertyValueFactory<>("item_price"));
        //tblUsers.getItems().clear();
        tblDown.setItems(oblist);
    }
    
}
