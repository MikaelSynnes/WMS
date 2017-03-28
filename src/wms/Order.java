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
      private String customerID;
     private String placedDate;
     private String invoiceDate;
     private String employeeID;
    
     
}
