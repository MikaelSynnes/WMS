/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wms;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author Mikael
 */
public class WMS extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button storage_overview_button = new Button();
        storage_overview_button.setText("Lageroversikt");
        storage_overview_button.setPrefSize(150, 50);
        storage_overview_button.setOnAction((ActionEvent event) -> {
            System.out.println("Lageroversikt!");
        });
        
        Button product_registration_button = new Button();
        product_registration_button.setText("Produktregistrering");
        product_registration_button.setPrefSize(150, 50);
        product_registration_button.setOnAction((ActionEvent event) -> {
            System.out.println("Produktregistrering!");
        });
        
        Button truck_overview_button = new Button();
        truck_overview_button.setText("Truck");
        truck_overview_button.setPrefSize(150, 50);
        truck_overview_button.setOnAction((ActionEvent event) -> {
            System.out.println("Truck!");
        });
        
        Button employee_overview_button = new Button();
        employee_overview_button.setText("Ansatte");
        employee_overview_button.setPrefSize(150, 50);
        employee_overview_button.setOnAction((ActionEvent event) -> {
            System.out.println("Ansatte!");
        });
        
        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(10, 10, 10, 10));
        flowPane.setVgap(4);
        flowPane.setHgap(4);
        flowPane.setPrefWrapLength(210);
        flowPane.setAlignment(Pos.CENTER);
        flowPane.getChildren().add(storage_overview_button);
        flowPane.getChildren().add(product_registration_button);
        flowPane.getChildren().add(truck_overview_button);
        flowPane.getChildren().add(employee_overview_button);
        
        
        
        
        Scene scene = new Scene(flowPane, 400, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
