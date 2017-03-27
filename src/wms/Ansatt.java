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
    private String AnsattId;
    private String Fornavn;
    private String Etternavn;
    private String Stilling;
    private String Epost;
    private String Telefon;

    public Ansatt(){}
    
    public Ansatt(String id, String fornavn, String etternavn, String stilling, String epost, String telefon) {
        this.AnsattId = id;
        this.Fornavn = fornavn;
        this.Etternavn = etternavn;
        this.Stilling = stilling;
        this.Epost = epost;
        this.Telefon = telefon;
    }

    
    
    public String getansattId() {
        return AnsattId;
    }

    public void setAnsattId(String id) {
        this.AnsattId = id;
    }

    public String getFornavn() {
        return Fornavn;
    }

    public void setFornavn(String fornavn) {
        this.Fornavn = fornavn;
    }

    public String getEtternavn() {
        return Etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.Etternavn = etternavn;
    }

    public String getStilling() {
        return Stilling;
    }

    public void setStilling(String stilling) {
        this.Stilling = stilling;
    }

    public String getEpost() {
        return Epost;
    }

    public void setEpost(String epost) {
        this.Epost = epost;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        this.Telefon = telefon;
    }
    
    
}
