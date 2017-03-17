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
    private String vareNummer;
    private String ordreNummber;
    private String antall;
    private String mottaker;
    private String plassering;
    private String dato;

    public Vare(String vareNummer, String ordreNummber, String antall, String mottaker, String plassering, String dato) {
        this.vareNummer = vareNummer;
        this.ordreNummber = ordreNummber;
        this.antall = antall;
        this.mottaker = mottaker;
        this.plassering = plassering;
        this.dato = dato;
    }

    public String getVareNummer() {
        return vareNummer;
    }

    public void setVareNummer(String vareNummer) {
        this.vareNummer = vareNummer;
    }

    public String getOrdreNummber() {
        return ordreNummber;
    }

    public void setOrdreNummber(String ordreNummber) {
        this.ordreNummber = ordreNummber;
    }

    public String getAntall() {
        return antall;
    }

    public void setAntall(String antall) {
        this.antall = antall;
    }

    public String getMotttaker() {
        return mottaker;
    }

    public void setMottaker(String mottaker) {
        this.mottaker = mottaker;
    }

    public String getPlassering() {
        return plassering;
    }

    public void setPlassering(String Plassering) {
        this.plassering = plassering;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
    
}
