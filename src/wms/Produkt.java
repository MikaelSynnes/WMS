/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wms;

/**
 *
 * @author Haava
 */
public class Produkt {
    private String VareId;
    private String Vnavn;
    private String Kategori;
    private String Dato;
    private String Plassering;

    public Produkt(String VareId, String Vnavn, String Kategori, String Dato) {
        this.VareId = VareId;
        this.Vnavn = Vnavn;
        this.Kategori = Kategori;
        this.Dato = Dato;
        this.Plassering = null;
    }
    
    public Produkt(){
        
    }

    public String getVareId() {
        return VareId;
    }

    public void setVareId(String VareId) {
        this.VareId = VareId;
    }

    public String getVnavn() {
        return Vnavn;
    }

    public void setVnavn(String Vnavn) {
        this.Vnavn = Vnavn;
    }

    public String getKategori() {
        return Kategori;
    }

    public void setKategori(String Kategori) {
        this.Kategori = Kategori;
    }

    public String getDato() {
        return Dato;
    }

    public void setDato(String Dato) {
        this.Dato = Dato;
    }

    public void setPlassering(String plassering){
        this.Plassering = plassering;
    }

    public String getPlassering(){
        return this.Plassering;
    }
}
