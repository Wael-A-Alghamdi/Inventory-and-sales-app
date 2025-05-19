/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asrock
 */
public class PaymentMethodCashController implements Initializable {

    @FXML
    private Button btnPay;
    @FXML
    private TextField cash;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void Pay(ActionEvent event) throws IOException, SQLException {
         
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("OrderSummary.fxml"));   
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
        
        ArrayList<String> onnum = new ArrayList<String>();
        OrderArr a=new OrderArr();
        OrderNum n=new OrderNum();
        Order u=new Order();
        onnum=n.getOrderNumber();
        u.InsertProfit(onnum.get(onnum.size()-1), a.sumTotal());
        u.DeleteOd(onnum.get(onnum.size()-1));
        a.Clear();
        
        u.insertOrder();
        
       
        
        
             
    }
    
}
