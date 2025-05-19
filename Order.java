/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;

/**
 *
 * @author asrock
 */
public class Order {
     private Connection connect() throws SQLException{
        Connection con=null;
        String url="jdbc:sqlite:C:/Users/asrock/Documents/NetBeansProjects/SAS.db";
        con=DriverManager.getConnection(url);
        System.err.println("Connection Established");
        return con;
    }
      public void insertOrder() throws SQLException {
          String any="";
        String sql="INSERT INTO Orders(any) VALUES('"+any+"')";
        Connection con=this.connect();
        Statement st=con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("The Order added....");

    }

   public void insertOrderD(String order_no,String item_name,int item_quantity,Double item_price) throws SQLException {
          
        String sql="INSERT INTO OrderDetails(order_no,item_name,item_quantity,item_price) VALUES('"+order_no+"','"+item_name+"','"+item_quantity+"','"+item_price+"')";
        Connection con=this.connect();
        Statement st=con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("The OrderD added....");

    }
   
   public void SelectOrder() throws SQLException {
        String sql="SELECT * FROM Orders";
        Connection con=this.connect();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(sql);
       
        OrderNum u=new OrderNum();
        while(rs.next()){
            
               String c=rs.getString("order_no");
                u.OrderNum(c);
                
            
        }
        st.close();
        con.close();
       
    }
   
       public void SearchOrderD(ObservableList oblist,String order_no) throws SQLException
        {
//             String sql = "SELECT * FROM Users WHERE name LIKE '"+name+"%'";
            String sql = "SELECT * FROM OrderDetails WHERE order_no='"+order_no+"'";
            Connection con = this.connect();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
          {
                oblist.add(new OrderDetailsTableView(rs.getString("order_no"),rs.getString("item_name"),rs.getInt("item_quantity"),rs.getDouble("item_price")));
          }
            st.close();
            con.close();
        }
       
    public void InsertProfit(String order_no,double money) throws SQLException {
        String sql="INSERT INTO Profit(order_no,money) VALUES('"+order_no+"','"+money+"')";
        Connection con=this.connect();
        Statement st=con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("The Profit added....");      
    }
    
    
    
      public void OrderData(ObservableList oblist) throws SQLException {
        String sql = "SELECT * FROM OrderDetails";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) 
{
                oblist.add(new OrderDetailsTableView(rs.getString("order_no"),rs.getString("item_name"),rs.getInt("item_quantity"),rs.getDouble("item_price")));
   }
        st.close();
        con.close();
        //return rs;

    }
      
      
    
     public void updateQuantity(int item_quantity, int id) throws SQLException
        {
            String sql = "UPDATE OrderDetails set item_quantity='"+item_quantity+"' WHERE id='"+id+"'";
            Connection con = this.connect();
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            st.close();
            con.close();
            
        }
     public int getId(String item_name) throws SQLException
        {
            String sql = "SELECT id FROM OrderDetails WHERE item_name='"+item_name+"'";
            Connection con = this.connect();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql);
             int id = rs.getInt("id");
             st.close();
            con.close();
            return id;
             
        }
     public void DeleteOd(String order_no) throws SQLException
        {
            String sql = "DELETE FROM OrderDetails WHERE order_no='"+order_no+"'";
            Connection con = this.connect();
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            
            st.close();
            con.close();
         
            
        }
     
    
     
       
    
}