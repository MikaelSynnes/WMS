
package wms;

/**
 * Created by aleksander on 3/21/17.

 * Vare for lageroversiktstabell klassa
 */
public class Vare3
{
    private String vareNummer;
    private String beskrivelse;
    private String type;
    private String antall;
    private String plassering;
    private String dato;


    public Vare3(String vareNummer, String beskrivelse, String type, String antall, String plassering, String dato) {
        this.vareNummer = vareNummer;
        this.beskrivelse = beskrivelse;
        this.type = type;
        this.antall = antall;
        this.plassering = plassering;
        this.dato = dato;
    }

    public String getVareNummer() {
        return vareNummer;
    }

    public void setVareNummer(String vareNummer) {
        this.vareNummer = vareNummer;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }



}
