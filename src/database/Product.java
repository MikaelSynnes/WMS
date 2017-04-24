/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.Map;

/**
 *
 * @author Mikael
 */

import java.util.ArrayList;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    double productID;
    String name;
    String description;
    int price;
    Map tax;
    boolean active;
    String version;
}
