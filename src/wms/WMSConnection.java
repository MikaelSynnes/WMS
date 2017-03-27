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

    private final String URL = "jdbc:sqlserver://haavafl-WMS1.uials.no;databaseName=WMS1;username=sa;password=passord123";
    private Connection con;

    public WMSConnection() {
        
        try {
            con = DriverManager.getConnection(URL);
        } catch (SQLException ex) {
            Logger.getLogger(WMSConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public List<Ansatt> getAnsatte() {
        
        List<Ansatt> ansatte = null;
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Ansatt");
            ansatte = new ArrayList<>();
            while (rs.next()) {
                Ansatt ansatt = new Ansatt();
                ansatt.setAnsattId(rs.getString("AnsattId"));
                ansatt.setFornavn(rs.getString("Fornavn"));
                ansatt.setEtternavn(rs.getString("Etternavn"));
                ansatt.setStilling(rs.getString("stiling"));
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

    public List<Produkt> getProdukt() {
        List<Produkt> produktList = null;
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Vare");
            produktList = new ArrayList<>();
            while (rs.next()) {
                Produkt vare = new Produkt();
                vare.setVareId(rs.getString("VareId"));
                vare.setVnavn(rs.getString("Vnavn"));
                vare.setKategori(rs.getString("Kategori"));
                vare.setDato(rs.getString("Dato"));
                produktList.add(vare);
            }

        } catch (SQLException ex) {
            Logger.getLogger(WMSConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return produktList;
    }

    public List<Truck> getTruck() {
        List<Truck> truckList = null;
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Truck");
            truckList = new ArrayList<>();
            while (rs.next()) {
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

    public List<Produkt> searchVare(String input) {
        List<Produkt> produktList = null;
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Vare LIKE"+ input);
            produktList = new ArrayList<>();
            while (rs.next()) {
                Produkt vare = new Produkt();
                vare.setVareId(rs.getString("VareId"));
                vare.setVnavn(rs.getString("Vnavn"));
                vare.setKategori(rs.getString("Kategori"));
                vare.setDato(rs.getString("Dato"));
                produktList.add(vare);
            }

        } catch (SQLException ex) {
            Logger.getLogger(WMSConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return produktList;
    }
}

