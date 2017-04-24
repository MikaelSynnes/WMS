package wms;

/**
 * Created by Kristian on 02.04.2017.
 */
public class Ordre {
    private int ordreID;
    private String butikk;
    private String vekt;
    private String dato;
    private String antall;
    private int ansatt;

    public Ordre(int ordreId, String butikk, String vekt, String dato, String antall, int ansatt) {
        this.ordreID = ordreId;
        this.butikk = butikk;
        this.vekt = vekt;
        this.dato = dato;
        this.antall = antall;
        this.ansatt = ansatt;
    }

    public int getOrdreId() {
        return ordreID;
    }
    public int Ansatt(){
        return ansatt;
    }

    public void setOrdreId(int ordreId) {
        this.ordreID = ordreID;
    }

    public String getButikk() {
        return butikk;
    }

    public void setButikk(String butikk) {
        this.butikk = butikk;
    }

    public String getVekt() {
        return vekt;
    }

    public void setVekt(String vekt) {
        this.vekt = vekt;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getAntall() {
        return antall;
    }

    public void setAntall(String antall) {
        this.antall = antall;
    }

    public int getAnsatt() {
        return ansatt;
    }

    public void setAnsatt(int plassering) {
        this.ansatt = plassering;
    }
}
