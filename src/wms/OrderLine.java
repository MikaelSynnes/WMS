/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wms;

/**
 *
 * @author Mikael
 */
public class OrderLine {
    int orderLineID;
    int orderID;
    int productID;
    int quantity;
    
    
    public OrderLine(int orderLineID,int orderID, int productID,int quantity){
        this.orderLineID=orderLineID;
        this.orderID=orderID;
        this.productID=productID;
        this.quantity=quantity;
        
        
    
}
    
    public void setOrderLineID(int i){
        orderLineID=i;
    }
     public void setOrderID(int i){
        orderID=i;
    }
     public void setProductID(int i){
        productID=i;
    }
    public void setQuantity(int i){
        quantity=i;
    }
    public int getOrderLineID(){
        return orderLineID;
    }
    public int getOrderID(){
        return orderID;
        
    }
    public int getProductID(){
        return productID;
    }
    public int getQuantity(){
        return quantity;
    }
}
