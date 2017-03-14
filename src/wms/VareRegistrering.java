/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wms;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Kristian
 */
public class VareRegistrering extends Application {
    
    ArrayList<Label> categories;
    
    @Override
    public void start(Stage primaryStage) {
        double minWidth;
        double minHeight;
        
        //header
        Label header = new Label("Vare Registrering");
        header.setFont(new Font(40));
        
        TableView<String> table = new TableView<Person>();
        table.setEditable(true);

        
        //table info
        //categories = new ArrayList<Label>();
        TableColumn wareNumber = new TableColumn("Vare nummber");
        //categories.add(wareNumber);
        TableColumn orderNumber = new TableColumn("Ordrenummer");
        //categories.add(orderNumber);
        TableColumn numberOf = new TableColumn("Antall");
        //categories.add(numberOf);
        TableColumn reciever = new TableColumn("Mottaker");
        //categories.add(reciever);
        TableColumn placement = new TableColumn("Plassering");
        //categories.add(placement);
        TableColumn date = new TableColumn("dato");
        //categories.add(date);
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        
        //Header box
        VBox headerBox = new VBox();
        headerBox.getChildren().add(header);
        headerBox.setAlignment(Pos.CENTER);
        
        //Table
       /* VBox tableBox = new VBox();
        for(Label l : categories){
            tableBox.getChildren().add(l);
        }*/
       
       table.setItems(data);
       table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        
        
        root.add(headerBox, 0, 0);
        //root.add(tableBox,0,1);
        root.setColumnSpan(headerBox, 2);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Vare Registrering");
        primaryStage.setScene(scene);
        primaryStage.show();
        minWidth = primaryStage.getWidth();
        minHeight = primaryStage.getHeight();
        primaryStage.setMinWidth(minWidth);
        primaryStage.setMinHeight(minHeight);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
