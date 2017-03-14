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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * @author Mikael
 */
public class WMS extends Application
{

    ArrayList<Button> buttons;

    @Override
    public void start(Stage primaryStage)
    {
        buttons = new ArrayList<Button>();

        double minWidth;
        double minHeight;

        // Tittel
        Label header = new Label("WMS-System");
        header.setFont(new Font(40));
        header.setPadding(new Insets(20));

        Font buttonFont = new Font(20);

        // lager knapper og legger dem til i en ArrayList for å legge dem til i scena uten og å måtte kode duplisere
        Button btn = createButton("Lageroversikt", null, primaryStage);
        buttons.add(btn);
        Button btn2 = createButton("Vareregistrering", null, primaryStage);
        buttons.add(btn2);
        Button btn3 = createButton("Truck", null, primaryStage);
        buttons.add(btn3);
        Button btn4 = createButton("Ansatte", null, primaryStage);
        buttons.add(btn4);

        for (Button currentButton : buttons)
        {
            currentButton.setFont(buttonFont);
        }

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);

        VBox headerBox = new VBox();
        headerBox.getChildren().add(header);
        headerBox.setAlignment(Pos.CENTER);


        for (Button b : buttons)
        {
            root.setMargin(b, new Insets(20));
        }

        // Legg til header og knapper
        root.add(headerBox, 0, 0);
        root.setColumnSpan(headerBox, 2);
        root.add(btn, 0, 1);
        root.add(btn2, 1, 1);
        root.add(btn3, 0, 2);
        root.add(btn4, 1, 2);
        Scene scene = new Scene(root);

        primaryStage.setTitle("WMS 2000");
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
    public static void main(String[] args)
    {
        launch(args);
    }


    // Lager en knapp med posisjon pixels int,int og String tekst, Og hvor knappen skal lede til null (scene).

    public Button createButton(String title, Scene scene, Stage primaryStage)
    {
        Button btn = new Button();

        btn.setText(title);
        btn.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                primaryStage.setScene(scene);
            }
        });

        btn.setMinSize(250, 150);
        return btn;
    }

}
