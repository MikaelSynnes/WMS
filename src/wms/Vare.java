package wms;

import javafx.beans.property.SimpleStringProperty;

import javax.print.DocFlavor;

/**
 * Created by aleksander on 3/17/17.
 */
public class Vare {
    private final String vareNummer;
    private final String beskrivelse;
    private final String type;
    private final String antall;
    private final String plassering;
    private final String dato;

    public Vare(String vareNummer, String beskrivelse, String type, String antall, String plassering, String dato) {
        this.vareNummer = vareNummer;
        this.beskrivelse = beskrivelse;
        this.type = type;
        this.antall = antall;
        this.plassering = plassering;
        this.dato = dato;
    }

    public String getVarenummer() {
        return vareNummer;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public String getType() {
        return type;
    }

    public String getAntall() {
        return antall;
    }

    public String getPlassering() {
        return plassering;
    }

    public String getDato() {
        return dato;
    }
}