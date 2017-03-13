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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

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


        // lager knapper og legger dem til i en ArrayList for å legge dem til i scena uten og å måtte kode duplisere
        Button btn = createButton("Tekst", null, primaryStage);
        buttons.add(btn);
        Button btn2 = createButton("Tekst", null, primaryStage);
        buttons.add(btn2);
        Button btn3 = createButton("Tekst", null, primaryStage);
        buttons.add(btn3);
        Button btn4 = createButton("Tekst", null, primaryStage);
        buttons.add(btn4);

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);


        for (Button b : buttons)
        {
            root.setMargin(b, new Insets(20));
        }

        root.add(btn, 0, 0);
        root.add(btn2, 1, 0);
        root.add(btn3, 0, 1);
        root.add(btn4, 1, 1);
        Scene scene = new Scene(root, 800, 600);
        root.setMinWidth(scene.getWidth());
        root.setMinHeight(scene.getHeight());

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
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
