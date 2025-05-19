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
public class Report {
    private Connection connect() throws SQLException{
        Connection con=null;
        String url="jdbc:sqlite:C:/Users/asrock/Documents/NetBeansProjects/SAS.db";
        con=DriverManager.getConnection(url);
        System.err.println("Connection Established");
        return con;
    }
    public void insertReport(String topic,String content) throws SQLException {
        String sql="INSERT INTO Reports(topic,content) VALUES('"+topic+"','"+content+"')";
        Connection con=this.connect();
        Statement st=con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("The Report Send....");
    }
    public void ReportData(ObservableList oblist) throws SQLException {
        String sql = "SELECT * FROM Reports";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) //            {
        {
            oblist.add(new ReportTableView(rs.getString("topic"),rs.getString("content")));
        }
//            }
        st.close();
        con.close();
        //return rs;

    }
}
