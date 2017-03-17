/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wms;

import javafx.scene.control.Label;

/**
 *
 * @author Kristian
 */
public class Footer {
    private String title;

    public Footer() {
        this.title = "This is a footer";
    }
    
    public Label createFooter(){
        Label footer = new Label(title);
        
        
        return footer;
    }
}
