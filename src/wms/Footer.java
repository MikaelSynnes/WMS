/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wms;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author Kristian
 */
public class Footer {
    private String title;

    public Footer() {
        this.title = "This is a footer";
    }
    
    public VBox createFooter(){
        Label footer = new Label(title);
        VBox vb = new VBox();
        vb.getChildren().addAll(footer);
        vb.setAlignment(Pos.CENTER);
        
        return vb;
    }
}
