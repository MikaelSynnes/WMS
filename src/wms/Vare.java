/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wms;

/**
 *
 * @author Kristian
 */
public class Vare {
    private int vareNummer;
    private int ordreNummber;
    private int antall;
    private String mottaker;
    private String Plassering;
    private String dato;

    public Vare(int vareNummer, int ordreNummber, int antall, String mottaker, String Plassering, String dato) {
        this.vareNummer = vareNummer;
        this.ordreNummber = ordreNummber;
        this.antall = antall;
        this.mottaker = mottaker;
        this.Plassering = Plassering;
        this.dato = dato;
    }

    public int getVareNummer() {
        return vareNummer;
    }

    public void setVareNummer(int vareNummer) {
        this.vareNummer = vareNummer;
    }

    public int getOrdreNummber() {
        return ordreNummber;
    }

    public void setOrdreNummber(int ordreNummber) {
        this.ordreNummber = ordreNummber;
    }

    public int getAntall() {
        return antall;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }

    public String getMotttaker() {
        return mottaker;
    }

    public void setMottaker(String mottaker) {
        this.mottaker = mottaker;
    }

    public String getPlassering() {
        return Plassering;
    }

    public void setPlassering(String Plassering) {
        this.Plassering = Plassering;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
    
}
