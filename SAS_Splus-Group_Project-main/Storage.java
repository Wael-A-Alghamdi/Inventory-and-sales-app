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
public class Storage {
    private Connection connect() throws SQLException{
        Connection con=null;
        String url="jdbc:sqlite:C:/Users/asrock/Documents/NetBeansProjects/SAS.db";
        con=DriverManager.getConnection(url);
        System.err.println("Connection Established");
        return con;
    }
    public void insertItem(String item_name,String item_code,String item_quantity,double item_price) throws SQLException {
        String sql="INSERT INTO Storage(item_name,item_code,item_quantity,item_price) VALUES('"+item_name+"','"+item_code+"','"+item_quantity+"','"+item_price+"')";
        Connection con=this.connect();
        Statement st=con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        AdminMainPageController a=new AdminMainPageController();
       
        System.out.println("Item added....");

    }
     public void StorageData(ObservableList oblist) throws SQLException {
        String sql = "SELECT * FROM Storage";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) 
{
            oblist.add(new StorageTableView(rs.getInt("id"),rs.getString("item_name"),rs.getString("item_code"),rs.getInt("item_quantity"),rs.getDouble("item_price")));
   }
        st.close();
        con.close();
        //return rs;

    }
     public boolean ScaneItems(String item_code) throws SQLException {
        String sql="SELECT * FROM Storage";
        Connection con=this.connect();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(sql);
        boolean check=false;
        OrderArr u=new OrderArr();
        while(rs.next()){
            String c=rs.getString("item_code");
            
            if ((item_code.equals(c))) {
                String n=rs.getString("item_name");
                double p=rs.getDouble("item_price");
                u.OrderDt(n,p);
                check=true;
                break;
            }
        }
        st.close();
        con.close();
        return check;

    }
     public void SearchStorage(ObservableList oblist,String item_code) throws SQLException
        {
//             String sql = "SELECT * FROM Users WHERE name LIKE '"+name+"%'";
            String sql = "SELECT * FROM Storage WHERE item_code='"+item_code+"'";
            Connection con = this.connect();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
          {
            oblist.add(new StorageTableView(rs.getInt("id"),rs.getString("item_name"),rs.getString("item_code"),rs.getInt("item_quantity"),rs.getDouble("item_price")));
           }
            st.close();
            con.close();
        }
     
     public void DeleteItem(String item_code) throws SQLException
        {
            String sql = "DELETE FROM Storage WHERE item_code='"+item_code+"'";
            Connection con = this.connect();
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            
            st.close();
            con.close();
         
            
        }
     public void updateItem(String item_name,String item_code,int item_quantity,double item_price, int id) throws SQLException
        {
            String sql = "UPDATE Storage set item_name='"+item_name+"', item_code='"+item_code+"', item_quantity='"+item_quantity+"', item_price='"+item_price+"' WHERE id='"+id+"'";
            Connection con = this.connect();
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            st.close();
            con.close();
            
        }
     public int getId(String item_code) throws SQLException
        {
            String sql = "SELECT id FROM Storage WHERE item_code='"+item_code+"'";
            Connection con = this.connect();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql);
             int id = rs.getInt("id");
             st.close();
            con.close();
            return id;
             
        }
     public void UpdateQun(int item_quantity,String item_code) throws SQLException
        {
            String sql = "UPDATE Storage set item_quantity='"+item_quantity+"' WHERE item_code='"+item_code+"'";
            Connection con = this.connect();
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            st.close();
            con.close();
            
        }
       
       
         public Integer SelectStorage(String item_code) throws SQLException {
        String sql = "SELECT * FROM Storage WHERE item_code='"+item_code+"'";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        ResultSet rs = st.executeQuery(sql);
        
         int o;
      if(true){
      o=rs.getInt("item_quantity");
   }
                     

   
        st.close();
        con.close();
        return o;

    }
      
}

