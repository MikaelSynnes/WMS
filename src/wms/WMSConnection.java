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

    public List<Vare3> getVare3() {
        List<Vare3> vare3List = null;
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Vare3");
            vare3List = new ArrayList<>();
            while (rs.next()) {
                Vare3 vare3 = new Vare3();
                vare3.setVareNummer(rs.getString("Varenummer"));
                vare3.setBeskrivelse(rs.getString("Beskrivelse"));
                vare3.setType(rs.getString("Type"));
                vare3.setAntall(rs.getString("Antall"));
                vare3.setPlassering(rs.getString("Plassering"));
                vare3.setDato(rs.getString("Dato"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(WMSConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return vare3List;


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

