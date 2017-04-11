/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wms;

import javafx.scene.control.Label;
import javafx.scene.text.Font;


/**
 *
 * @author Kristian
 */
public class Header {
    private String title;


    public Header(String title ) {
        this.title = title;
        
        
    }
    
        public Label createHeader(){
        Label header = new Label(title);
        
        header.setFont(new Font(30));
        
        return header;
    }
}