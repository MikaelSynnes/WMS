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
public class Vare2 {
    private String varenummer;
    private String ordrenummer;
    private String antall;
    private String mottaker;
    private String plassering;
    private String dato;

    public Vare2(String varenummer, String ordrenummer, String antall, String mottaker, String plassering, String dato) {
        this.varenummer = varenummer;
        this.ordrenummer = ordrenummer;
        this.antall = antall;
        this.mottaker = mottaker;
        this.plassering = plassering;
        this.dato = dato;
    }

    public String getVarenummer() {
        return varenummer;
    }

    public void setVarenummer(String varenummer) {
        this.varenummer = varenummer;
    }

    public String getOrdrenummer() {
        return ordrenummer;
    }

    public void setOrdrenummer(String ordrenummer) {
        this.ordrenummer = ordrenummer;
    }

    public String getAntall() {
        return antall;
    }

    public void setAntall(String antall) {
        this.antall = antall;
    }

    public String getMottaker() {
        return mottaker;
    }

    public void setMottaker(String mottaker) {
        this.mottaker = mottaker;
    }

    public String getPlassering() {
        return plassering;
    }

    public void setPlassering(String plassering) {
        this.plassering = plassering;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
    
}
