/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wms;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * @author Mikael
 */
public class WMS extends Application {

    GridPane root;
    ArrayList<Button> buttons;
    Scene scene;

    VBox headerBox;
    VareRegistrering reg;
    Lageroversikttabell lager;
    tableTruck truck;
    tableAnsatt ansatt;

    public WMS() {
        root = new GridPane();
        scene = new Scene(root);
        headerBox = new VBox();
        reg = new VareRegistrering();
        lager= new Lageroversikttabell();
        truck = new tableTruck();
        ansatt = new tableAnsatt();

    }

    @Override
    public void start(Stage primaryStage) {
        buttons = new ArrayList<Button>();

        double minWidth;
        double minHeight;

        // Tittel
        Label header = new Label("WMS");
        header.setFont(new Font(40));
        header.setPadding(new Insets(20));

        Font buttonFont = new Font(20);
       

        // lager knapper og legger dem til i en ArrayList for å legge dem til i scena uten og å måtte kode duplisere
        Button btn = createButton("Lageroversikt", lager.getScene(primaryStage), primaryStage);
        buttons.add(btn);
        Button btn2 = createButton("Vareregistrering", reg.getScene(primaryStage), primaryStage);
        buttons.add(btn2);
        Button btn3 = createButton("Truck", truck.getScene(primaryStage), primaryStage);
        buttons.add(btn3);
        Button btn4 = createButton("Ansatte", ansatt.getScene(primaryStage), primaryStage);
        buttons.add(btn4);

        for (Button currentButton : buttons) {
            currentButton.setFont(buttonFont);

        }

        root.setAlignment(Pos.CENTER);

        headerBox.getChildren().add(header);
        headerBox.setAlignment(Pos.CENTER);

        for (Button b : buttons) {
            root.setMargin(b, new Insets(20));
        }

        // Legg til header og knapper
        root.add(headerBox, 0, 0);
        root.setColumnSpan(headerBox, 2);
        root.add(btn, 0, 1);
        root.add(btn2, 1, 1);
        root.add(btn3, 0, 2);
        root.add(btn4, 1, 2);

        primaryStage.setTitle("WMS 2000");

        primaryStage.setScene(scene);
        minWidth = primaryStage.getWidth();
        minHeight = primaryStage.getHeight();
        primaryStage.setMinWidth(450);
        primaryStage.setMinHeight(620);
        primaryStage.show();
        /*  Button storage_overview_button = new Button();
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
        
         */

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    // Lager en knapp med posisjon pixels int,int og String tekst, Og hvor knappen skal lede til null (scene).
    public Button createButton(String title, Scene scene, Stage primaryStage) {
        Button btn = new Button();

        btn.setText(title);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(scene);
            }
        });

        btn.setMinSize(250, 150);
        return btn;
    }

}
