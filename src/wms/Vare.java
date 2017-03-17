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

    Vare(String vNummer, String bs, String tp, String ant, String pl, String dt) {
        this.vareNummer = new String(vNummer);
        this.beskrivelse = new String(bs);
        this.type = new String(tp);
        this.antall = new String(ant);
        this.plassering = new String(pl);
        this.dato = new String(dt);
    }

    public String getVareNummer() {
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