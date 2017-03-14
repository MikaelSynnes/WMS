package wms;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Haava
 */
public class WMSConnection {
    /*
    public static Connection WMSConnection() {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=WMS1;username=haavafl;password=wms123";
            con = DriverManager.getConnection(url);
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Kunde");
            List<String> customers = new ArrayList<>();
            while(rs.next()){
                customers.add("id:; "+rs.getInt(1)+" navn: "+rs.getString(2));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(WMSConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    */
    public static void main(String[] args) {
        Connection con = null;
        List<String> customers = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://haavafl-WMS1.uials.no;databaseName=WMS1;username=sa;password=passord123";
            con = DriverManager.getConnection(url);
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Kunde");
            customers = new ArrayList<>();
            while(rs.next()){
                customers.add("id:; "+rs.getInt(1)+" navn: "+rs.getString(2));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(WMSConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(customers!=null){
            for(String s : customers){
                System.out.println(s);
            }
        }
    }
    
}
