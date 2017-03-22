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
public class Ansatt {
    private String id;
    private String fornavn;
    private String etternavn;
    private String stilling;
    private String epost;
    private String telefon;

    public Ansatt(){}
    
    public Ansatt(String id, String fornavn, String etternavn, String stilling, String epost, String telefon) {
        this.id = id;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.stilling = stilling;
        this.epost = epost;
        this.telefon = telefon;
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getStilling() {
        return stilling;
    }

    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    
}
