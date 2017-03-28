package wms;/**
 * Created by aleksander on 3/14/17.
 */

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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


    private final TableView<Vare3> table;
    private final ObservableList<Vare3> data;
    final HBox hb;
    final HBox hbox;
    final HBox lhb;

    public Lageroversikttabell() {
        this.hb = new HBox();
        this.hbox = new HBox();
        this.lhb = new HBox();
        this.data = FXCollections.observableArrayList(new Vare3("A", "B", "C", "D", "E", "F"));
        this.table = new TableView<>();
    }


    public Scene getScene(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Lager oversikt");



        final Label label = new Label("Lager oversikt");
        label.setFont(new Font("Arial", 20));


        // Søk knapp
        final Button Btn1 = new Button ("Søk");
        TextField textField = new TextField();
        textField.setMaxWidth(130);



        table.setEditable(true);

        //kollonner
        TableColumn vareNummer = new TableColumn("Varenummer");
        vareNummer.setMinWidth(125);
        vareNummer.setCellValueFactory(new PropertyValueFactory<>("varenummer"));

        TableColumn beskrivelse = new TableColumn("Beskrivelse");
        beskrivelse.setMinWidth(125);
        beskrivelse.setCellValueFactory(new PropertyValueFactory<>("beskrivelse"));
        TableColumn type = new TableColumn("Type");
        type.setMinWidth(125);
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        TableColumn antall = new TableColumn("Antall");
        antall.setMinWidth(125);
        antall.setCellValueFactory(new PropertyValueFactory<>("antall"));
        TableColumn plassering = new TableColumn("Plassering");
        plassering.setMinWidth(125);
        plassering.setCellValueFactory(new PropertyValueFactory<>("plassering"));
        TableColumn dato = new TableColumn("Dato");
        dato.setMinWidth(125);
        dato.setCellValueFactory(new PropertyValueFactory<>("dato"));

        table.setItems(data);
        table.getColumns().addAll(vareNummer, beskrivelse, type, antall, plassering, dato);

        //tilbake kanpp
        final Button tilbake = new Button("Tilbake");
        tilbake.setPrefSize(150, 20);
        tilbake.setOnAction((ActionEvent e) ->{
            WMStest w = new WMStest();
            w.start(stage);
        });
        hb.getChildren().addAll(tilbake);

        // legg til labels
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
        addAntall.setPromptText("Antall");
        addAntall.setMaxWidth(110);

        final TextField addPlassering = new TextField();
        addPlassering.setPromptText("Plassering");
        addPlassering.setMaxWidth(110);
      
      
        final TextField addDato = new TextField();
        addDato.setPromptText("Dato");
        addDato.setMaxWidth(110);

        // legg til knapp
        final Button addButton = new Button("Legg til");



        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Vare3(
                        addVareNummer.getText(),
                        addBeskrivelse.getText(),
                        addType.getText(),
                        addAntall.getText(),
                        addPlassering.getText(),
                        addDato.getText()
                ));
                addVareNummer.clear();
                addBeskrivelse.clear();
                addType.clear();
                addAntall.clear();
                addPlassering.clear();
                addDato.clear();
            }
        });



        lhb.getChildren().addAll(addVareNummer, addBeskrivelse, addType, addAntall, addPlassering, addDato, addButton);



       
   


        lhb.getChildren().addAll(addVareNummer, addBeskrivelse, addType, addAntall, addPlassering, addDato, addButton);

        lhb.setSpacing(3);

        hbox.setSpacing(5);

        hbox.getChildren().addAll(textField, Btn1);

        final VBox vbox = new VBox();
        vbox.setSpacing (5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(label, hbox, table, lhb, hb);

        hb.setAlignment(Pos.BASELINE_LEFT);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);

        stage.show();
        stage.setWidth(stage.getWidth());
        stage.setHeight(stage.getHeight());

        return scene;
    }

}
