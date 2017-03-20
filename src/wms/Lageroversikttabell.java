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
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Lageroversikttabell {


    private final TableView<Vare> table;
    private final ObservableList<Vare> data;
    final HBox hb;
    final HBox hbox;
    final HBox lhb;

    public Lageroversikttabell() {
        this.hb = new HBox();
        this.hbox = new HBox();
        this.lhb = new HBox();
        this.data = FXCollections.observableArrayList(new Vare("A", "B", "C", "D", "E", "F"));
        this.table = new TableView<>();
    }


    public Scene getScene(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Lager oversikt");



        final Label label = new Label("Lager oversikt");
        label.setFont(new Font("Arial", 20));

        final Button Btn1 = new Button ("Søk");
        TextField textField = new TextField();
        textField.setMaxWidth(130);



        table.setEditable(true);


        TableColumn vareNummer = new TableColumn("Varenummer");
        vareNummer.setMinWidth(110);
        vareNummer.setCellValueFactory(new PropertyValueFactory<>("varenummer"));

        TableColumn beskrivelse = new TableColumn("Beskrivelse");
        beskrivelse.setMinWidth(110);
        beskrivelse.setCellValueFactory(new PropertyValueFactory<>("beskrivelse"));
        TableColumn type = new TableColumn("Type");
        type.setMinWidth(110);
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        TableColumn antall = new TableColumn("Antall");
        antall.setMinWidth(110);
        antall.setCellValueFactory(new PropertyValueFactory<>("antall"));
        TableColumn plassering = new TableColumn("Plassering");
        plassering.setMinWidth(110);
        plassering.setCellValueFactory(new PropertyValueFactory<>("plassering"));
        TableColumn dato = new TableColumn("Dato");
        dato.setMinWidth(110);
        dato.setCellValueFactory(new PropertyValueFactory<>("dato"));

        table.setItems(data);
        table.getColumns().addAll(vareNummer, beskrivelse, type, antall, plassering, dato);

        final Button tilbake = new Button("Tilbake");
        tilbake.setOnAction((ActionEvent e) ->{
             WMS w = new WMS();
            w.start(stage);

        });
        hb.getChildren().addAll(tilbake);


        final TextField addVareNummer = new TextField();
        addVareNummer.setPromptText("Varenummer");
        addVareNummer.setMaxWidth(110);

        final TextField addBeskrivelse = new TextField();
        addBeskrivelse.setPromptText("Beskrivelse");
        addBeskrivelse.setMaxWidth(110);

        final TextField addType = new TextField();
        addType.setPromptText("Type");
        addType.setMaxWidth(110);

        final TextField addAntall = new TextField();



        lhb.getChildren().addAll(addVareNummer, addBeskrivelse);
        final Button Search = new Button("Søk");

        final Button addButton = new Button("Legg til");
        addButton.setOnAction((ActionEvent e) ->{
           // data.add
        });

       hb.getChildren().addAll(addButton);

        hb.setSpacing(3);
        hbox.setSpacing(5);

        hbox.getChildren().addAll(textField, Btn1);

        final VBox vbox = new VBox();
        vbox.setSpacing (5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(label, hbox, table, lhb, hb);

        hb.setAlignment(Pos.BASELINE_RIGHT);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);

        stage.show();
        stage.setWidth(stage.getWidth());
        stage.setHeight(stage.getHeight());

        return scene;
    }

}
