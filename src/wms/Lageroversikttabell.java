package wms;/**
 * Created by aleksander on 3/14/17.
 */

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;

import javafx.geometry.Pos;
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



        final Label label = new Label("Lager oversikt");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);


        TableColumn vareNummer = new TableColumn("Varenummer");
        vareNummer.setMinWidth(100);
        vareNummer.setCellValueFactory(new PropertyValueFactory<>("varenummer"));

        TableColumn beskrivelse = new TableColumn("Beskrivelse");
        beskrivelse.setMinWidth(100);
        beskrivelse.setCellValueFactory(new PropertyValueFactory<>("beskrivelse"));
        TableColumn type = new TableColumn("Type");
        type.setMinWidth(100);
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        TableColumn antall = new TableColumn("Antall");
        antall.setMinWidth(100);
        antall.setCellValueFactory(new PropertyValueFactory<>("antall"));
        TableColumn plassering = new TableColumn("Plassering");
        plassering.setMinWidth(100);
        plassering.setCellValueFactory(new PropertyValueFactory<>("plassering"));
        TableColumn dato = new TableColumn("Dato");
        dato.setMinWidth(100);
        dato.setCellValueFactory(new PropertyValueFactory<>("dato"));

        table.setItems(data);
        table.getColumns().addAll(vareNummer, beskrivelse, type, antall, plassering, dato);

        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) ->{
            data.add(new Vare("X", "Y", "J", "i", "s", "o"));
        });

       hb.getChildren().addAll(addButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing (5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(table, hb);
        hb.setAlignment(Pos.BASELINE_RIGHT);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);

        stage.show();
        stage.setWidth(stage.getWidth());
        stage.setHeight(stage.getHeight());

    }
}
