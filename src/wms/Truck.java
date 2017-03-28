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
public class Truck {
    private String TruckId;
    private String Ansvarlig;
    private String Operativ;
    private String Model;
    private String Neste_service;

    public Truck(String TruckId, String Ansvarlig, String Operativ, String Model, String Neste_service) {
        this.TruckId = TruckId;
        this.Ansvarlig = Ansvarlig;
        this.Operativ = Operativ;
        this.Model = Model;
        this.Neste_service = Neste_service;
    }
public Truck(){}

    public String getTruckId() {
        return TruckId;
    }

    public void setTruckId(String TruckId) {
        this.TruckId = TruckId;
    }

    public String getAnsvarlig() {
        return Ansvarlig;
    }

    public void setAnsvarlig(String Ansvarlig) {
        this.Ansvarlig = Ansvarlig;
    }

    public String getOperativ() {
        return Operativ;
    }

    public void setOperativ(String Operativ) {
        this.Operativ = Operativ;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getNeste_service() {
        return Neste_service;
    }

    public void setNeste_service(String Neste_service) {
        this.Neste_service = Neste_service;
    }
}
