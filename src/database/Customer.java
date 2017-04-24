/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mikael
 */

package database;

import java.util.ArrayList;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Customer {
    int customerID;
    String name;
    String phoneNumber;
    String email;
    String address;
     Map zipCode;
    boolean active;
    
 
    
    
    
    
}
