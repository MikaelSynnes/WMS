package wms;

/**
 * Created by Kristian on 17.04.2017.
 */
public class Historikk {
    private String dato;
    private String plassering;
    private String vareId;
    private String ordreId;

    public Historikk(String dato, String plassering, String vareId, String ordreId) {
        this.dato = dato;
        this.plassering = plassering;
        this.vareId = vareId;
        this.ordreId = ordreId;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getPlassering() {
        return plassering;
    }

    public void setPlassering(String plassering) {
        this.plassering = plassering;
    }

    public String getVareId() {
        return vareId;
    }

    public void setVareId(String vareId) {
        this.vareId = vareId;
    }

    public String getOrdreId() {
        return ordreId;
    }

    public void setOrdreId(String ordreId) {
        this.ordreId = ordreId;
    }
}
