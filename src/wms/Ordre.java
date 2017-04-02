package wms;

/**
 * Created by Kristian on 02.04.2017.
 */
public class Ordre {
    private String ordreId;
    private String butikk;
    private String vekt;
    private String dato;
    private String antall;
    private String plassering;

    public Ordre(String ordreId, String butikk, String vekt, String dato, String antall, String plassering) {
        this.ordreId = ordreId;
        this.butikk = butikk;
        this.vekt = vekt;
        this.dato = dato;
        this.antall = antall;
        this.plassering = plassering;
    }

    public String getOrdreId() {
        return ordreId;
    }

    public void setOrdreId(String ordreId) {
        this.ordreId = ordreId;
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

    public String getPlassering() {
        return plassering;
    }

    public void setPlassering(String plassering) {
        this.plassering = plassering;
    }
}
