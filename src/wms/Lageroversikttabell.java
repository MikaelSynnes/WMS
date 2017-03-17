package wms;/**
 * Created by aleksander on 3/14/17.
 */

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class Lageroversikttabell extends Application {


    private final TableView<Vare> table = new TableView<>();
    private final ObservableList<Vare> data = FXCollections.observableArrayList(new Vare("A", "B", "C", "D", "E", "F"));
    final HBox hb = new HBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Lager oversikt");
        stage.setWidth(600);
        stage.setHeight(500);

        final Label label = new Label("Lager oversikt");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);


        TableColumn vareNummer = new TableColumn("Varenummer");
        vareNummer.setMinWidth(100);
        vareNummer.setCellFactory(new PropertyValueFactory<>("varenummer"));

        TableColumn beskrivelse = new TableColumn("Beskrivelse");
        beskrivelse.setMinWidth(100);
        beskrivelse.setCellFactory(new PropertyValueFactory<>("beskrivelse"));
        TableColumn type = new TableColumn("Type");
        type.setMinWidth(100);
        type.setCellFactory(new PropertyValueFactory<>("type"));
        TableColumn antall = new TableColumn("Antall");
        antall.setMinWidth(100);
        antall.setCellFactory(new PropertyValueFactory<>("antall"));
        TableColumn plassering = new TableColumn("Plassering");
        plassering.setMinWidth(100);
        plassering.setCellFactory(new PropertyValueFactory<>("plassering"));
        TableColumn dato = new TableColumn("Dato");
        dato.setMinWidth(100);
        dato.setCellFactory(new PropertyValueFactory<>("dato"));

        table.setItems(data);
        table.getColumns().addAll(vareNummer, beskrivelse, type, antall, plassering, dato);

        //final Button addButton = new Button("Add");
        //addButton.setOnAction((ActionEvent e) ->{
          //  data.add(new Vare("X", "Y", "J", "i", "s", "o"));
        //});

     //   hb.getChildren().addAll(addButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing (5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();


    }
}
