/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mikael
 */
package wms;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order {

    private int orderID;
    private int customerID;
    private int employeeID;
    private String placedDate;
    private String invoiceDate;

    public void setOrderID(int i) {
        orderID = i;
    }

    public void setCustomerID(int i) {
        customerID = i;
    }

    public void setEmployeeID(int i) {
        employeeID = i;
    }

    public void setPlacedDate(String i) {
        placedDate = i;
    }

    public void setInvoiceDate(String i) {
        invoiceDate = i;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int setEmployeeID() {
        return employeeID;
    }

    public String getPlacedDate() {
        return placedDate;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

}
