package wms;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    
    private final String URL = "jdbc:sqlserver://haavafl-WMS1.uials.no;databaseName=WMS1;username=sa;password=passord123";
    private Connection con;
    private PreparedStatement addAnsattStatement;
    private PreparedStatement addTruckStatement;

    
    public WMSConnection(){
        try{
            con = DriverManager.getConnection(URL);
            prepareStatements();
        } catch (SQLException ex) {
            Logger.getLogger(WMSConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage()); 
        } 
    }
    
    private void prepareStatements(){
        try {
            addAnsattStatement = con.prepareStatement("INSERT INTO Ansatt VALUES(?, ?, ?, ?, ?, ?)");
            addTruckStatement = con.prepareStatement("INSERT INTO Truck (TruckId, Ansvarlig, Operativ, Model, Neste_service) VALUES(?, ?, ?, ?, ?)");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<Ansatt> getAnsatte(){
        List<Ansatt> ansatte = null;
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Ansatt");
            ansatte = new ArrayList<>();
            while(rs.next()){
                Ansatt ansatt = new Ansatt();
                ansatt.setAnsattId(rs.getString("AnsattId"));
                ansatt.setFornavn(rs.getString("Fornavn"));
                ansatt.setStilling(rs.getString("Stilling"));
                ansatt.setAvdeling(rs.getString("Avdeling"));
                ansatt.setEpost(rs.getString("Epost"));
                ansatt.setTelefon(rs.getString("Telefon"));
                ansatte.add(ansatt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WMSConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } 
        return ansatte;
    }
    public void addAnsatte(Ansatt ansatt){
         try {
            addAnsattStatement.setInt(1, Integer.parseInt(ansatt.getAnsattId()));
            addAnsattStatement.setString(2, ansatt.getFornavn());
            addAnsattStatement.setString(3, ansatt.getStilling());
            addAnsattStatement.setString(4, ansatt.getAvdeling());
            addAnsattStatement.setString(5, ansatt.getEpost());
            addAnsattStatement.setInt(6, Integer.parseInt(ansatt.getTelefon()));
            int updates = addAnsattStatement.executeUpdate();
            
         }catch (SQLException ex) {
            Logger.getLogger(WMSConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
    }
    }
    public List<Produkt> getProdukt() {
        List<Produkt> produktList = null;
        try {
             Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Vare");
            produktList = new ArrayList<>();
            while(rs.next()) {
                Produkt vare = new Produkt();
                vare.setVareId(rs.getString("VareId"));
                vare.setVnavn(rs.getString("Vnavn"));
                vare.setKategori(rs.getString("Kategori"));
                vare.setDato(rs.getString("Dato"));
                produktList.add(vare);
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(WMSConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } 
        return produktList;
    }
        public List<Truck> getTruck(){
        List<Truck> truckList = null;
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Truck");
            truckList = new ArrayList<>();
            while(rs.next()){
                Truck truck = new Truck();
                truck.setTruckId(rs.getString("TruckId"));
                truck.setAnsvarlig(rs.getString("Ansvarlig"));
                truck.setOperativ(rs.getString("Operativ"));
                truck.setModel(rs.getString("Model"));
                truck.setNeste_service(rs.getString("Neste_service"));
                truckList.add(truck);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WMSConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } 
        return truckList;

}
                    public void addTruck(Truck truck){
         try {
           
            addTruckStatement.setInt(1, Integer.parseInt(truck.getTruckId()));
            addTruckStatement.setString(2, truck.getAnsvarlig());
            addTruckStatement.setString(3, truck.getOperativ());
            addTruckStatement.setString(4, truck.getModel());
            addTruckStatement.setString(5, truck.getNeste_service());
            int updates = addTruckStatement.executeUpdate();

         }catch (SQLException ex) {
            Logger.getLogger(WMSConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
    }


        }
    public List<Ordre> getOrdre(){
         List<Ordre> ordreList = null;
         try{
             Statement s = con.createStatement();
             ResultSet rs = s.executeQuery("SELECT * FROM Ordre");
             ordreList = new ArrayList<>();
             while (rs.next()){
                 Ordre ordre = new Ordre("","","","","","");
                 ordre.setOrdreId(rs.getString("OrdreId"));
                 ordre.setButikk(rs.getString("butikk"));
                 ordre.setVekt(rs.getString("Vekt"));
                 ordre.setDato(rs.getString("Dato"));
                 ordre.setAntall(rs.getString("Antall"));
                 ordre.setPlassering(rs.getString("Plassering"));
                 ordreList.add(ordre);

             }
         }catch (SQLException ex){
             Logger.getLogger(WMSConnection.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println(ex.getMessage());
         }
         return ordreList;
    }
    public String getPassword() {

        String password = null;
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Bruker");

            while (rs.next()) {
                Userpass userpass = new Userpass();
                userpass.setPass(rs.getString("Passord"));
                password = userpass.getPass();


            }
        } catch (SQLException ex) {
            Logger.getLogger(WMSConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return password;
    }


    public String getUser() {
        String username = null;

        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Bruker");

            while (rs.next()) {
                Userpass userpass = new Userpass();
                userpass.setUser(rs.getString("BrukerNavn"));
                username = userpass.getUser();
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(WMSConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return username;

    }
}
