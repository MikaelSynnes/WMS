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
    private String ansattId;
    private String fornavn;
    private String stilling;
    private String avdeling;
    private String epost;
    private String telefon;

    public Ansatt() {
    }

    public Ansatt(String id, String fornavn, String avdeling, String stilling, String epost, String telefon) {
        this.ansattId = id;
        this.fornavn = fornavn;
        this.stilling = stilling;
        this.avdeling = avdeling;
        this.epost = epost;
        this.telefon = telefon;
    }

    public String getAnsattId() {
        return ansattId;
    }

    public void setAnsattId(String ansattId) {
        this.ansattId = ansattId;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getStilling() {
        return stilling;
    }

    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

    public String getAvdeling() {
        return avdeling;
    }

    public void setAvdeling(String avdeling) {
        this.avdeling = avdeling;
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

    
    
