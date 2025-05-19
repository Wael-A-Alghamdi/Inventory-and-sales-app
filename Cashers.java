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

/**
 *
 * @author asrock
 */
public class Cashers {
      private Connection connects() throws SQLException{
        Connection con=null;
        String url="jdbc:sqlite:C:/Users/asrock/Documents/NetBeansProjects/SAS.db";
        con=DriverManager.getConnection(url);
        System.err.println("Connection Established");
        return con;
    }
      public void insertCasher(String name,String phone_number,String user_id,String password) throws SQLException {
        String sql="INSERT INTO Cashers(name,phone_number,user_id,password) VALUES('"+name+"','"+phone_number+"','"+user_id+"','"+password+"')";
        Connection con = this.connects();
        Statement st=con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("The Casher added....");

    }
     public boolean loginCasher(String user_id,String password) throws SQLException {
        String sql= "SELECT * FROM Cashers";
        Connection con=this.connects();
        Statement st=con.createStatement();
        ResultSet rs =st.executeQuery(sql);
        boolean check = false;
        while(rs.next()){
            String u = rs.getString("user_id");
            String p = rs.getString("password");
            if(user_id .equals(u) & password.equals(p)){
                check = true;
                break;
            }
        }
        st.close();
        con.close();
        return check;
    }
}
